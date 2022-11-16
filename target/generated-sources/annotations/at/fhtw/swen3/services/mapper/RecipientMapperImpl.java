package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-16T20:34:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public Recipient entityToDto(RecipientEntity author) {
        if ( author == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setName( author.getName() );
        recipient.setStreet( author.getStreet() );
        recipient.setPostalCode( author.getPostalCode() );
        recipient.setCity( author.getCity() );
        recipient.setCountry( author.getCountry() );

        return recipient;
    }

    @Override
    public RecipientEntity dtoToEntity(Recipient authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setCountry( authorDto.getCountry() );
        recipientEntity.setName( authorDto.getName() );
        recipientEntity.setStreet( authorDto.getStreet() );
        recipientEntity.setPostalCode( authorDto.getPostalCode() );
        recipientEntity.setCity( authorDto.getCity() );

        return recipientEntity;
    }
}
