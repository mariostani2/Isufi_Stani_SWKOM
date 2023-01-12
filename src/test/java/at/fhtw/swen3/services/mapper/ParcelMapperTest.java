package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelMapperTest {
    private ParcelMapper mapper=ParcelMapper.INSTANCE;
    @Test
    void dtoToEntity(){
        Parcel parcelDto=new Parcel(5.5f,new Recipient().name("recipient"),new Recipient().name("sender"));

        TrackingInformation trackingInformationDto=new TrackingInformation();
        trackingInformationDto.setState(TrackingInformation.StateEnum.DELIVERED);

        NewParcelInfo newParcelInfoDto = new NewParcelInfo();
        newParcelInfoDto.setTrackingId("adsfasdfasdfasdfasdfadsd");

        ParcelEntity entity=mapper.dtoToEntity(parcelDto,newParcelInfoDto,trackingInformationDto);

        assertEquals(newParcelInfoDto.getTrackingId(),entity.getTrackingId());
        assertEquals(parcelDto.getRecipient().getName(),entity.getRecipient().getName());
        assertEquals(trackingInformationDto.getState(),entity.getState());

    }

    @Test
    void entityToParcelDto(){

        List<HopArrivalEntity> visitedHops = new ArrayList<>();
        List<HopArrivalEntity> futureHops = new ArrayList<>();

    RecipientEntity    recipient = RecipientEntity.builder().build();
        recipient.setName("Rec1");
        recipient.setStreet("Teststrasse 13");
        recipient.setPostalCode("1070");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

  RecipientEntity      sender = RecipientEntity.builder().build();
        sender.setName("Sen1");
        sender.setStreet("Teststrasse 13");
        sender.setPostalCode("1070");
        sender.setCity("Wien");
        sender.setCountry("Österreich");

    ParcelEntity   entity = ParcelEntity.builder()
                .trackingId("P12345678")
                .visitedHops(visitedHops)
                .futureHops(futureHops)
                .recipient(recipient)
                .sender(sender)
                .state(TrackingInformation.StateEnum.DELIVERED)
                .weight(6.f)
                .build();
        Parcel parcelDto=mapper.entityToParcelDto(entity);

        System.out.println(parcelDto);
        assertEquals(parcelDto.getWeight(),entity.getWeight());
        assertEquals(parcelDto.getRecipient().getName(),entity.getRecipient().getName());
    }

    @Test
    void entityToTrackingInformationDto(){
        ParcelEntity entity=new ParcelEntity(30l,RecipientEntity.builder().build(), RecipientEntity.builder().build(), "RD4343", TrackingInformation.StateEnum.DELIVERED, new LinkedList<>(){}, new LinkedList<>());
        TrackingInformation trackingInformationDto=mapper.entityToTrackingInformationDto(entity);
        assertEquals(trackingInformationDto.getState(),entity.getState());
    }

    @Test
    void entityToNewParcelInfoDto(){
        ParcelEntity entity=ParcelEntity.builder()
                .trackingId("RD4343")
                .state(ParcelEntity.StateEnum.DELIVERED).build();
        NewParcelInfo newParcelInfoDto= mapper.parcelEntityToNewParcelInfoDto(entity);
        assertEquals(newParcelInfoDto.getTrackingId(),entity.getTrackingId());
    }


}
