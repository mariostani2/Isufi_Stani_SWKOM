package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T16:29:25+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class HopMapperImpl implements HopMapper {

    @Override
    public Hop entityToDto(HopEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Hop hop = new Hop();

        hop.setHopType( entity.getHopType() );
        hop.setCode( entity.getCode() );
        hop.setDescription( entity.getDescription() );
        hop.setProcessingDelayMins( entity.getProcessingDelayMins() );
        hop.setLocationName( entity.getLocationName() );
        hop.setLocationCoordinates( geoCoordinateEntityToGeoCoordinate( entity.getLocationCoordinates() ) );

        return hop;
    }

    @Override
    public HopEntity dtoToEntity(Hop dto) {
        if ( dto == null ) {
            return null;
        }

        HopEntity hopEntity = new HopEntity();

        hopEntity.setHopType( dto.getHopType() );
        hopEntity.setCode( dto.getCode() );
        hopEntity.setDescription( dto.getDescription() );
        hopEntity.setProcessingDelayMins( dto.getProcessingDelayMins() );
        hopEntity.setLocationName( dto.getLocationName() );
        hopEntity.setLocationCoordinates( geoCoordinateToGeoCoordinateEntity( dto.getLocationCoordinates() ) );

        return hopEntity;
    }

    protected GeoCoordinate geoCoordinateEntityToGeoCoordinate(GeoCoordinateEntity geoCoordinateEntity) {
        if ( geoCoordinateEntity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( geoCoordinateEntity.getLat() );
        geoCoordinate.setLon( geoCoordinateEntity.getLon() );

        return geoCoordinate;
    }

    protected GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();

        geoCoordinateEntity.setLat( geoCoordinate.getLat() );
        geoCoordinateEntity.setLon( geoCoordinate.getLon() );

        return geoCoordinateEntity;
    }
}
