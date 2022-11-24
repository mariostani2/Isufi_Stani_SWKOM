package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-24T16:21:50+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class ErrorMapperImpl implements ErrorMapper {

    @Override
    public Error entityToDto(ErrorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Error error = new Error();

        error.setErrorMessage( entity.getErrorMessage() );

        return error;
    }

    @Override
    public ErrorEntity dtoToEntity(Error dto) {
        if ( dto == null ) {
            return null;
        }

        ErrorEntity errorEntity = new ErrorEntity();

        errorEntity.setErrorMessage( dto.getErrorMessage() );

        return errorEntity;
    }
}
