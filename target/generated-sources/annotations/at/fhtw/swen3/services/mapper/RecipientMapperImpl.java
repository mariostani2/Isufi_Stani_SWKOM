package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T14:14:49+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public Recipient entityToDto(RecipientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setName( entity.getName() );
        recipient.setStreet( entity.getStreet() );
        recipient.setPostalCode( entity.getPostalCode() );
        recipient.setCity( entity.getCity() );
        recipient.setCountry( entity.getCountry() );

        return recipient;
    }

    @Override
    public RecipientEntity dtoToEntity(Recipient dto) {
        if ( dto == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.country( dto.getCountry() );
        recipientEntity.name( dto.getName() );
        recipientEntity.street( dto.getStreet() );
        recipientEntity.postalCode( dto.getPostalCode() );
        recipientEntity.city( dto.getCity() );

        return recipientEntity.build();
    }
}
