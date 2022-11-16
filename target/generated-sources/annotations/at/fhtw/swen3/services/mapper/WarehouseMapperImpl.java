package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-17T00:02:47+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class WarehouseMapperImpl implements WarehouseMapper {

    @Override
    public Warehouse entityToDto(WarehouseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.hopType( entity.getHopType() );
        warehouse.code( entity.getCode() );
        warehouse.description( entity.getDescription() );
        warehouse.processingDelayMins( entity.getProcessingDelayMins() );
        warehouse.locationName( entity.getLocationName() );
        warehouse.locationCoordinates( geoCoordinateEntityToGeoCoordinate( entity.getLocationCoordinates() ) );
        warehouse.setLevel( entity.getLevel() );
        warehouse.setNextHops( warehouseNextHopsEntityListToWarehouseNextHopsList( entity.getNextHops() ) );

        return warehouse;
    }

    @Override
    public WarehouseEntity dtoToEntity(Warehouse dto) {
        if ( dto == null ) {
            return null;
        }

        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setHopType( dto.getHopType() );
        warehouseEntity.setCode( dto.getCode() );
        warehouseEntity.setDescription( dto.getDescription() );
        warehouseEntity.setProcessingDelayMins( dto.getProcessingDelayMins() );
        warehouseEntity.setLocationName( dto.getLocationName() );
        warehouseEntity.setLocationCoordinates( geoCoordinateToGeoCoordinateEntity( dto.getLocationCoordinates() ) );
        warehouseEntity.setLevel( dto.getLevel() );
        warehouseEntity.setNextHops( warehouseNextHopsListToWarehouseNextHopsEntityList( dto.getNextHops() ) );

        return warehouseEntity;
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

    protected Hop hopEntityToHop(HopEntity hopEntity) {
        if ( hopEntity == null ) {
            return null;
        }

        Hop hop = new Hop();

        hop.setHopType( hopEntity.getHopType() );
        hop.setCode( hopEntity.getCode() );
        hop.setDescription( hopEntity.getDescription() );
        hop.setProcessingDelayMins( hopEntity.getProcessingDelayMins() );
        hop.setLocationName( hopEntity.getLocationName() );
        hop.setLocationCoordinates( geoCoordinateEntityToGeoCoordinate( hopEntity.getLocationCoordinates() ) );

        return hop;
    }

    protected WarehouseNextHops warehouseNextHopsEntityToWarehouseNextHops(WarehouseNextHopsEntity warehouseNextHopsEntity) {
        if ( warehouseNextHopsEntity == null ) {
            return null;
        }

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setTraveltimeMins( warehouseNextHopsEntity.getTraveltimeMins() );
        warehouseNextHops.setHop( hopEntityToHop( warehouseNextHopsEntity.getHop() ) );

        return warehouseNextHops;
    }

    protected List<WarehouseNextHops> warehouseNextHopsEntityListToWarehouseNextHopsList(List<WarehouseNextHopsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHops> list1 = new ArrayList<WarehouseNextHops>( list.size() );
        for ( WarehouseNextHopsEntity warehouseNextHopsEntity : list ) {
            list1.add( warehouseNextHopsEntityToWarehouseNextHops( warehouseNextHopsEntity ) );
        }

        return list1;
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

    protected HopEntity hopToHopEntity(Hop hop) {
        if ( hop == null ) {
            return null;
        }

        HopEntity hopEntity = new HopEntity();

        hopEntity.setHopType( hop.getHopType() );
        hopEntity.setCode( hop.getCode() );
        hopEntity.setDescription( hop.getDescription() );
        hopEntity.setProcessingDelayMins( hop.getProcessingDelayMins() );
        hopEntity.setLocationName( hop.getLocationName() );
        hopEntity.setLocationCoordinates( geoCoordinateToGeoCoordinateEntity( hop.getLocationCoordinates() ) );

        return hopEntity;
    }

    protected WarehouseNextHopsEntity warehouseNextHopsToWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops) {
        if ( warehouseNextHops == null ) {
            return null;
        }

        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();

        warehouseNextHopsEntity.setTraveltimeMins( warehouseNextHops.getTraveltimeMins() );
        warehouseNextHopsEntity.setHop( hopToHopEntity( warehouseNextHops.getHop() ) );

        return warehouseNextHopsEntity;
    }

    protected List<WarehouseNextHopsEntity> warehouseNextHopsListToWarehouseNextHopsEntityList(List<WarehouseNextHops> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHopsEntity> list1 = new ArrayList<WarehouseNextHopsEntity>( list.size() );
        for ( WarehouseNextHops warehouseNextHops : list ) {
            list1.add( warehouseNextHopsToWarehouseNextHopsEntity( warehouseNextHops ) );
        }

        return list1;
    }
}
