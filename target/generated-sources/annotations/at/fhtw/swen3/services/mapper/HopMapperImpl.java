package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-16T20:34:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class HopMapperImpl implements HopMapper {

    @Override
    public Hop entityToDto(HopEntity author) {
        if ( author == null ) {
            return null;
        }

        Hop hop = new Hop();

        hop.setHopType( author.getHopType() );
        hop.setCode( author.getCode() );
        hop.setDescription( author.getDescription() );
        hop.setProcessingDelayMins( author.getProcessingDelayMins() );
        hop.setLocationName( author.getLocationName() );
        hop.setLocationCoordinates( geoCoordinateEntityToGeoCoordinate( author.getLocationCoordinates() ) );

        return hop;
    }

    @Override
    public HopEntity dtoToEntity(Hop authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        HopEntity hopEntity = new HopEntity();

        hopEntity.setHopType( authorDto.getHopType() );
        hopEntity.setCode( authorDto.getCode() );
        hopEntity.setDescription( authorDto.getDescription() );
        hopEntity.setProcessingDelayMins( authorDto.getProcessingDelayMins() );
        hopEntity.setLocationName( authorDto.getLocationName() );
        hopEntity.setLocationCoordinates( geoCoordinateToGeoCoordinateEntity( authorDto.getLocationCoordinates() ) );

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
