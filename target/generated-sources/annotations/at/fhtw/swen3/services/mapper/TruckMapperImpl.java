package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity.TruckEntityBuilder;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-11T20:04:12+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    private final GeoCoordinateMapper geoCoordinateMapper = Mappers.getMapper( GeoCoordinateMapper.class );

    @Override
    public TruckEntity dtoToEntity(Truck truckDto) {
        if ( truckDto == null ) {
            return null;
        }

        TruckEntityBuilder<?, ?> truckEntity = TruckEntity.builder();

        truckEntity.numberPlate( truckDto.getNumberPlate() );
        truckEntity.regionGeoJson( truckDto.getRegionGeoJson() );
        truckEntity.hopType( truckDto.getHopType() );
        truckEntity.code( truckDto.getCode() );
        truckEntity.description( truckDto.getDescription() );
        truckEntity.processingDelayMins( truckDto.getProcessingDelayMins() );
        truckEntity.locationName( truckDto.getLocationName() );
        truckEntity.locationCoordinates( geoCoordinateMapper.dtoToEntity( truckDto.getLocationCoordinates() ) );

        return truckEntity.build();
    }

    @Override
    public Truck entityToDto(TruckEntity truckEntity) {
        if ( truckEntity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setNumberPlate( truckEntity.getNumberPlate() );
        truck.setRegionGeoJson( truckEntity.getRegionGeoJson() );
        truck.hopType( truckEntity.getHopType() );
        truck.code( truckEntity.getCode() );
        truck.description( truckEntity.getDescription() );
        truck.processingDelayMins( truckEntity.getProcessingDelayMins() );
        truck.locationName( truckEntity.getLocationName() );
        truck.locationCoordinates( geoCoordinateMapper.entityToDto( truckEntity.getLocationCoordinates() ) );

        return truck;
    }
}
