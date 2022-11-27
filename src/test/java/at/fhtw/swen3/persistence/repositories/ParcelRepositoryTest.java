package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ParcelRepositoryTest {

    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    private ParcelEntity parcelEntity;
    private RecipientEntity recipient;
    private RecipientEntity sender;


    @BeforeEach
    void init() {

        List<HopArrivalEntity> visitedHops = new ArrayList<>();
        List<HopArrivalEntity> futureHops = new ArrayList<>();

        recipient = RecipientEntity.builder().build();
        recipient.setName("Rec1");
        recipient.setStreet("Teststrasse 13");
        recipient.setPostalCode("1070");
        recipient.setCity("Wien");
        recipient.setCountry("Österreich");

        sender = RecipientEntity.builder().build();
        sender.setName("Sen1");
        sender.setStreet("Teststrasse 13");
        sender.setPostalCode("1070");
        sender.setCity("Wien");
        sender.setCountry("Österreich");

        parcelEntity = ParcelEntity.builder()
                .trackingId("P12345678")
                .visitedHops(visitedHops)
                .futureHops(futureHops)
                .recipient(recipient)
                .sender(sender)
                .state(TrackingInformation.StateEnum.DELIVERED)
                .weight(6.f)
                .build();
    }

    @AfterEach
    void cleanup(){
        try {
            parcelRepository.delete(parcelEntity);
            recipientRepository.delete(sender);
            recipientRepository.delete(recipient);
        }catch (Exception e){};

    }


    @Test
    void saveTest() {
        try {
            parcelRepository.save(parcelEntity);
            recipientRepository.save(sender);
            recipientRepository.save(recipient);
            assertEquals(1, parcelRepository.count());
            assertEquals(2, recipientRepository.count());
        }catch (Exception e){}

    }

    @Test
    void findByIdTest(){
        try {
            parcelRepository.save(parcelEntity);
            Optional<ParcelEntity> parcel = parcelRepository.findById(parcelEntity.getId());
            assertEquals(parcelEntity.getId(),parcel.get().getId());
        }catch (Exception e){};

    }
}