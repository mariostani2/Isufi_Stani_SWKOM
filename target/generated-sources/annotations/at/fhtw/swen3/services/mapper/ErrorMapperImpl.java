package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.ErrorEntity.ErrorEntityBuilder;
import at.fhtw.swen3.services.dto.Error;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T22:55:17+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class ErrorMapperImpl implements ErrorMapper {

    @Override
    public ErrorEntity dtoToEntity(Error errorDto) {
        if ( errorDto == null ) {
            return null;
        }

        ErrorEntityBuilder errorEntity = ErrorEntity.builder();

        errorEntity.errorMessage( errorDto.getErrorMessage() );

        return errorEntity.build();
    }

    @Override
    public Error entityToDto(ErrorEntity errorEntity) {
        if ( errorEntity == null ) {
            return null;
        }

        Error error = new Error();

        error.setErrorMessage( errorEntity.getErrorMessage() );

        return error;
    }
}
