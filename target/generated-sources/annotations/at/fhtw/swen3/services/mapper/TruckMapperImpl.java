package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-16T20:34:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public Truck entityToDto(TruckEntity author) {
        if ( author == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( author.getRegionGeoJson() );
        truck.setNumberPlate( author.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity dtoToEntity(Truck authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        TruckEntity truckEntity = new TruckEntity();

        truckEntity.setRegionGeoJson( authorDto.getRegionGeoJson() );
        truckEntity.setNumberPlate( authorDto.getNumberPlate() );

        return truckEntity;
    }
}
