package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T18:11:44+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class GeoCoordinateMapperImpl implements GeoCoordinateMapper {

    @Override
    public GeoCoordinate entityToDto(GeoCoordinateEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( entity.getLat() );
        geoCoordinate.setLon( entity.getLon() );

        return geoCoordinate;
    }

    @Override
    public GeoCoordinateEntity dtoToEntity(GeoCoordinate dto) {
        if ( dto == null ) {
            return null;
        }

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();

        geoCoordinateEntity.setLat( dto.getLat() );
        geoCoordinateEntity.setLon( dto.getLon() );

        return geoCoordinateEntity;
    }
}
