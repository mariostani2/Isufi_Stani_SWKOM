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
        RecipientEntity recipient=RecipientEntity.builder().build();
        recipient.setName("recip");
        ParcelEntity parcelEntity=new ParcelEntity();
        parcelEntity.setSender(RecipientEntity.builder().build());
        parcelEntity.setRecipient(RecipientEntity.builder().build());
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

//    @Test
//    void recipientEntityValidationAustriaTestFalse(){
//        RecipientEntity recipient= RecipientEntity.builder().name("Reldi").country("Austria").build();
//       assertEquals(false,recipient.isValid());
//    }
//
//    @Test
//    void recipientEntityValidationOesterreichTest(){
//        RecipientEntity recipient= RecipientEntity.builder().name("Mario").country("Österreich").build();
//        assertEquals(false,recipient.isValid());
//
//    }
//
//    @Test
//    void recipientEntityValidationNotAustriaTest(){
//        RecipientEntity recipient=RecipientEntity.builder().country("Germany").build();
//        assertEquals(true,recipient.isValid());
//
//    }

    @Test
    void hopArrivalEntityValidationTest(){
        HopArrivalEntity hopArrival = HopArrivalEntity.builder().code("2332").dateTime(null).description(null).build();
        Set<ConstraintViolation<HopArrivalEntity>> violations = validator.validate(hopArrival);
        assertEquals(violations.size(),3);
    }
}
