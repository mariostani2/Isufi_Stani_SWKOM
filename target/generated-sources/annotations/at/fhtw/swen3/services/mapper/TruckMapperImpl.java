package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T16:29:25+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public Truck entityToDto(TruckEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( entity.getRegionGeoJson() );
        truck.setNumberPlate( entity.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity dtoToEntity(Truck dto) {
        if ( dto == null ) {
            return null;
        }

        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setRegionGeoJson( dto.getRegionGeoJson() );
        truckEntity.setNumberPlate( dto.getNumberPlate() );

        return truckEntity;
    }
}
