package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ValidationTests {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    void parcelEntityValidationTest(){
        RecipientEntity recipient=new RecipientEntity();
        recipient.setName("recip");
        ParcelEntity parcelEntity=new ParcelEntity();
        parcelEntity.setSender(new RecipientEntity());
        parcelEntity.setRecipient(new RecipientEntity());
        parcelEntity.setFutureHops(new LinkedList<>());

        parcelEntity.setTrackingId("RD4343");//validator violation

        parcelEntity.setVisitedHops(new LinkedList<>());
        parcelEntity.setState(TrackingInformation.StateEnum.DELIVERED);

        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(parcelEntity);
//        for (ConstraintViolation<ParcelEntity> violation : violations) {
//            System.out.println(violation.getMessage());
//        }
        assertEquals(1,violations.size());
    }

    @Test
    void recipientEntityValidationAustriaTest(){
        RecipientEntity recipient= new RecipientEntity();
        recipient.setName("Mario");
        recipient.setCity("Vienna");
        recipient.setCountry("Austria");
        recipient.setPostalCode("A-1080");
        recipient.setStreet("Laudongasse 36");

       assertEquals(true,recipient.isValid());

    }

    @Test
    void recipientEntityValidationOesterreichTest(){
        RecipientEntity recipient= new RecipientEntity();
        recipient.setName("Mario");
        recipient.setCountry("Österreich");
        assertEquals(false,recipient.isValid());

    }

    @Test
    void recipientEntityValidationNotAustriaTest(){
        RecipientEntity recipient= new RecipientEntity();
        recipient.setCountry("Germany");
        assertEquals(true,recipient.isValid());

    }

    @Test
    void hopArrivalEntityValidationTest(){
        HopArrivalEntity hopArrival=new HopArrivalEntity();
        hopArrival.setCode("2332");
        hopArrival.setDateTime(null);
        hopArrival.setDescription(null);
        Set<ConstraintViolation<HopArrivalEntity>> violations = validator.validate(hopArrival);
        assertEquals(violations.size(),2);
    }
}
