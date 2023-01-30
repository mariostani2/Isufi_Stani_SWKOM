package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.NominatimGeoService;
import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final RecipientRepository recipientRepository;
    @Autowired
    private final HopRepository hopRepository;

    @Autowired
    private final NominatimGeoService nominatimGeoService;

    @Autowired
    private  final WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Autowired
    private  final WarehouseRepository warehouseRepository;

    @Autowired
    private final HopArrivalRepository hopArrivalRepository;

    @Autowired
    private final TransferwarehouseRepository transferwarehouseRepository;






    @Override
    public void reportParcelDelivery(String trackingId) {
        Optional<ParcelEntity> parcel = parcelRepository.findByTrackingId(trackingId);
        ParcelEntity parcelEntity=parcel.get();
        parcelEntity.setState(ParcelEntity.StateEnum.DELIVERED);
        parcelEntity.getFutureHops().stream().forEach(hopArrivalEntity -> {hopArrivalEntity.setVisited(true);});
        hopArrivalRepository.saveAll(parcelEntity.getFutureHops());
        parcelRepository.save(parcelEntity);
    }

    @Override
    public void reportParcelHop(String trackingId, String code) throws DALException, BLException {
        ParcelEntity parcel;
        try {
            Optional<ParcelEntity> parcelOpt = parcelRepository.findByTrackingId(trackingId);
            parcel=parcelOpt.get();
        }catch (Exception e) {
            throw new BLException();
        }
        try{
            HopArrivalEntity hopArrival=hopArrivalRepository.findFirstByParcelAndCodeAndVisited(parcel, code, false).get();
            hopArrival.setVisited(true);
            hopArrivalRepository.save(hopArrival);

            HopEntity hop=hopRepository.getFirstByCode(code).get();
            switch(hop.getHopType()) {
                case "truck":
                    parcel.setState(ParcelEntity.StateEnum.INTRUCKDELIVERY);
                    break;
                case "warehouse":
                    parcel.setState(ParcelEntity.StateEnum.INTRANSPORT);
                    break;
                case "transferwarehouse":
                    TransferwarehouseEntity transferwarehouse=transferwarehouseRepository.findTransferwarehouseEntitiesByCode(hop.getCode()).get();
                    callPartnerService(transferwarehouse.getLogisticsPartnerUrl(),parcel.getTrackingId());
                    parcel.setState(ParcelEntity.StateEnum.TRANSFERRED);
            }
            parcelRepository.save(parcel);
        }catch (Exception e){
            throw new DALException();
        }

    }

    @Override
    public void submitNewParcel(ParcelEntity parcelEntity) throws DALException, BLException {
    try {
        parcelEntity.setVisitedHops(new LinkedList<>());
        parcelEntity.setFutureHops(getFutureHops(parcelEntity));
        parcelEntity.setState(ParcelEntity.StateEnum.PICKUP);
        String trackingId = RandomStringUtils.randomAlphabetic(9);
        parcelEntity.setTrackingId(trackingId.toUpperCase());
    }catch (Exception e){
        log.error("Sumbit parcel failed: BL");
        throw new BLException();

    }
    try{
        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());
        parcelRepository.save(parcelEntity);
        hopArrivalRepository.saveAll(parcelEntity.getFutureHops());

        log.info("New Parcel added, trackingId: "+parcelEntity.getTrackingId());
    }catch (Exception e){
        log.error("Submit Parcel failed: DAL");
        throw new DALException();
    }

    }

    private List<HopArrivalEntity> getFutureHops(ParcelEntity parcelEntity) {
        List<HopEntity> futureHopsSender= new ArrayList<>();
        HopEntity truckNearSender=getNearestTruck(parcelEntity.getSender());
        futureHopsSender.add(truckNearSender);

        List<HopEntity> futureHopsReceiver= new ArrayList<>();
        HopEntity truckNearReceiver=getNearestTruck(parcelEntity.getRecipient());
        futureHopsReceiver.add(truckNearReceiver);

        HopEntity whS;
        HopEntity whR;
        String codeS=truckNearSender.getCode();
        String codeR=truckNearReceiver.getCode();

        whS=getWarehouseNearTruck(codeS);
        futureHopsSender.add(whS);
        codeS=whS.getCode();
        whR=getWarehouseNearTruck(codeR);
        codeR=whR.getCode();
        futureHopsReceiver.add(getWarehouseNearTruck(codeR));
        int level=1;
        while(!whS.getCode().equals(whR.getCode()) || level==5){

            whS=warehouseRepository.findFirstByNextHopsIsContainingAndLevelAfter(warehouseNextHopsRepository
                    .findWarehouseNextHopsEntityByHop_Code(codeS),level).get();
            whR=warehouseRepository.findFirstByNextHopsIsContainingAndLevelAfter(warehouseNextHopsRepository
                    .findWarehouseNextHopsEntityByHop_Code(codeR),level).get();

            codeS=whS.getCode();
            futureHopsSender.add(whS);
            codeR=whR.getCode();
            futureHopsReceiver.add(whR);
            level++;

        }
        return mergeLists(futureHopsSender,futureHopsReceiver,parcelEntity);
    }

    private HopEntity getWarehouseNearTruck(String codeS) {
        return warehouseRepository.findFirstByNextHopsIsContaining(warehouseNextHopsRepository
                .findWarehouseNextHopsEntityByHop_Code(codeS)).get();
    }

    private List<HopArrivalEntity> mergeLists(List<HopEntity> futureHopsSender, List<HopEntity> futureHopsReceiver, ParcelEntity parcelEntity) {
        List<HopArrivalEntity> futureHops=new LinkedList<>();
        for(HopEntity futureHop:futureHopsSender){
            futureHops.add(new HopArrivalEntity(futureHop,parcelEntity));
        }
        HopEntity receiverHighestLevel=futureHopsReceiver.get(futureHopsReceiver.size()-1);
        HopEntity senderHighestLevel=futureHopsSender.get(futureHopsSender.size()-1);

        if(receiverHighestLevel.getCode().equals(senderHighestLevel.getCode())){
            WarehouseEntity rootWarehouse=warehouseRepository.getFirstByLevel(0).get();
            futureHops.add(new HopArrivalEntity(rootWarehouse,parcelEntity));
        }

        for(int i=futureHopsReceiver.size()-2;i>=0;i--){
            futureHops.add(new HopArrivalEntity(futureHopsReceiver.get(i),parcelEntity));
        }
        return futureHops;

    }


    private HopEntity getNearestTruck(RecipientEntity recipientEntity){
        Address address=new Address();
        address.setCity(recipientEntity.getCity());
        address.setStreet(recipientEntity.getStreet());
        address.setZip(recipientEntity.getPostalCode());

        GeoCoordinate geo=nominatimGeoService.encodeAddress(address);
        HopEntity nearestTruck=  hopRepository.findNearestHop(geo.getLat(),geo.getLon());
        return nearestTruck;
    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws DALException {
        try{
            Optional<ParcelEntity> parcel = parcelRepository.findByTrackingId(trackingId);
            return ParcelMapper.INSTANCE.parcelEntityToTrackingInformationDto(parcel.get());
        }catch (Exception e){
            throw new DALException();
        }

    }

    @Override
    public void transitionParcel(String trackingId, ParcelEntity parcelEntity) throws BLException, DALException {
        try{
            parcelEntity.setVisitedHops(new LinkedList<>());
            parcelEntity.setFutureHops(getFutureHops(parcelEntity));
            parcelEntity.setState(ParcelEntity.StateEnum.PICKUP);
            parcelEntity.setTrackingId(trackingId.toUpperCase());
        }catch (Exception e){
            throw new BLException();
        }
        try{
            recipientRepository.save(parcelEntity.getRecipient());
            recipientRepository.save(parcelEntity.getSender());
            parcelRepository.save(parcelEntity);
            hopArrivalRepository.saveAll(parcelEntity.getFutureHops());

            log.info("Parcel "+parcelEntity.getTrackingId()+" transfered");
        }catch (Exception e){
            throw new DALException();
        }

    }


    public void callPartnerService(String partnerUrl,String trackingId) {
        try{
            WebClient webClient = WebClient.create(partnerUrl+"/parcel/"+trackingId);
            Object request = new Object();
            webClient.post().bodyValue(request).retrieve().bodyToMono(Object.class).block();
        }catch (Exception e) {
            log.error("transfer Parcel failed: Partner URL call unsuccessful");
        }
    }
}
