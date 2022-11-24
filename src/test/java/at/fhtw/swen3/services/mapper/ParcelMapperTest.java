package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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
        RecipientEntity recipient=new RecipientEntity();
        recipient.setName("recip");
        ParcelEntity entity=new ParcelEntity(3l, recipient, new RecipientEntity(), "RD4343", TrackingInformation.StateEnum.DELIVERED, new LinkedList<>(){}, new LinkedList<>());
        Parcel parcelDto=mapper.entityToParcelDto(entity);

        assertEquals(parcelDto.getWeight(),entity.getWeight());
        assertEquals(parcelDto.getRecipient().getName(),entity.getRecipient().getName());
    }

    @Test
    void entityToTrackingInformationDto(){
        ParcelEntity entity=new ParcelEntity(30l, new RecipientEntity(), new RecipientEntity(), "RD4343", TrackingInformation.StateEnum.DELIVERED, new LinkedList<>(){}, new LinkedList<>());
        TrackingInformation trackingInformationDto=mapper.entityToTrackingInformationDto(entity);
        assertEquals(trackingInformationDto.getState(),entity.getState());
    }

    @Test
    void entityToNewParcelInfoDto(){
        ParcelEntity entity=new ParcelEntity(32l, new RecipientEntity(), new RecipientEntity(), "RD4343", TrackingInformation.StateEnum.DELIVERED, new LinkedList<>(){}, new LinkedList<>());
        NewParcelInfo newParcelInfoDto= mapper.entityToNewParcelInfoDto(entity);
        assertEquals(newParcelInfoDto.getTrackingId(),entity.getTrackingId());
    }


}
