package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final RecipientRepository recipientRepository;


    @Override
    public void reportParcelDelivery(String trackingId) {

    }

    @Override
    public void reportParcelHop(String trackingId, String code) {
    }

    @Override
    public void submitNewParcel(ParcelEntity parcelEntity) {
        parcelEntity.setVisitedHops(new LinkedList<>());
        parcelEntity.setFutureHops(new LinkedList<>());
        parcelEntity.setState(ParcelEntity.StateEnum.PICKUP);
        parcelEntity.setTrackingId("PYJRB4HZ6");
        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());
        parcelRepository.save(parcelEntity);
        log.info("New Parcel added, trackingId: "+parcelEntity.getTrackingId());
    }

    @Override
    public TrackingInformation trackParcel(String trackingId) {
        try{
            Optional<ParcelEntity> parcel = parcelRepository.findByTrackingId(trackingId);
            return ParcelMapper.INSTANCE.parcelEntityToTrackingInformationDto(parcel.get());
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public NewParcelInfo transitionParcel(String trackingId, Parcel parcel) {

        return null;
    }

}
