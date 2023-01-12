package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T15:12:29+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public RecipientEntity dtoToEntity(Recipient recipientDto) {
        if ( recipientDto == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.country( recipientDto.getCountry() );
        recipientEntity.city( recipientDto.getCity() );
        recipientEntity.postalCode( recipientDto.getPostalCode() );
        recipientEntity.street( recipientDto.getStreet() );
        recipientEntity.name( recipientDto.getName() );

        return recipientEntity.build();
    }

    @Override
    public Recipient entityToDto(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setCountry( recipientEntity.getCountry() );
        recipient.setCity( recipientEntity.getCity() );
        recipient.setPostalCode( recipientEntity.getPostalCode() );
        recipient.setStreet( recipientEntity.getStreet() );
        recipient.setName( recipientEntity.getName() );

        return recipient;
    }
}
