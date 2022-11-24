package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-24T16:21:50+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
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

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setCountry( dto.getCountry() );
        recipientEntity.setName( dto.getName() );
        recipientEntity.setStreet( dto.getStreet() );
        recipientEntity.setPostalCode( dto.getPostalCode() );
        recipientEntity.setCity( dto.getCity() );

        return recipientEntity;
    }
}
