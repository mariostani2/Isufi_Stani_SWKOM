package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.HopEntity.HopEntityBuilder;
import at.fhtw.swen3.services.dto.Hop;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-11T20:04:12+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class HopMapperImpl_ implements HopMapper {

    private final GeoCoordinateMapper geoCoordinateMapper = Mappers.getMapper( GeoCoordinateMapper.class );

    @Override
    public HopEntity dtoToEntity(Hop hopDto) {
        if ( hopDto == null ) {
            return null;
        }

        HopEntityBuilder<?, ?> hopEntity = HopEntity.builder();

        hopEntity.locationName( hopDto.getLocationName() );
        hopEntity.locationCoordinates( geoCoordinateMapper.dtoToEntity( hopDto.getLocationCoordinates() ) );
        hopEntity.processingDelayMins( hopDto.getProcessingDelayMins() );
        hopEntity.description( hopDto.getDescription() );
        hopEntity.code( hopDto.getCode() );
        hopEntity.hopType( hopDto.getHopType() );

        return hopEntity.build();
    }

    @Override
    public Hop entityToDto(HopEntity hopEntity) {
        if ( hopEntity == null ) {
            return null;
        }

        Hop hop = new Hop();

        hop.setLocationName( hopEntity.getLocationName() );
        hop.setLocationCoordinates( geoCoordinateMapper.entityToDto( hopEntity.getLocationCoordinates() ) );
        hop.setProcessingDelayMins( hopEntity.getProcessingDelayMins() );
        hop.setDescription( hopEntity.getDescription() );
        hop.setCode( hopEntity.getCode() );
        hop.setHopType( hopEntity.getHopType() );

        return hop;
    }
}
