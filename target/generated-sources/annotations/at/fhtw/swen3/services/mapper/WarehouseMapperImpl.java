package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity.WarehouseEntityBuilder;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-11T20:04:12+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class WarehouseMapperImpl implements WarehouseMapper {

    private final GeoCoordinateMapper geoCoordinateMapper = Mappers.getMapper( GeoCoordinateMapper.class );
    private final WarehouseNextHopsMapper warehouseNextHopsMapper = Mappers.getMapper( WarehouseNextHopsMapper.class );

    @Override
    public WarehouseEntity dtoToEntity(Warehouse warehouseDto) {
        if ( warehouseDto == null ) {
            return null;
        }

        WarehouseEntityBuilder<?, ?> warehouseEntity = WarehouseEntity.builder();

        warehouseEntity.nextHops( warehouseNextHopsListToWarehouseNextHopsEntityList( warehouseDto.getNextHops() ) );
        warehouseEntity.level( warehouseDto.getLevel() );
        warehouseEntity.hopType( warehouseDto.getHopType() );
        warehouseEntity.code( warehouseDto.getCode() );
        warehouseEntity.description( warehouseDto.getDescription() );
        warehouseEntity.processingDelayMins( warehouseDto.getProcessingDelayMins() );
        warehouseEntity.locationName( warehouseDto.getLocationName() );
        warehouseEntity.locationCoordinates( geoCoordinateMapper.dtoToEntity( warehouseDto.getLocationCoordinates() ) );

        return warehouseEntity.build();
    }

    @Override
    public Warehouse entityToDto(WarehouseEntity warehouseEntity) {
        if ( warehouseEntity == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setNextHops( warehouseNextHopsEntityListToWarehouseNextHopsList( warehouseEntity.getNextHops() ) );
        warehouse.setLevel( warehouseEntity.getLevel() );
        warehouse.hopType( warehouseEntity.getHopType() );
        warehouse.code( warehouseEntity.getCode() );
        warehouse.description( warehouseEntity.getDescription() );
        warehouse.processingDelayMins( warehouseEntity.getProcessingDelayMins() );
        warehouse.locationName( warehouseEntity.getLocationName() );
        warehouse.locationCoordinates( geoCoordinateMapper.entityToDto( warehouseEntity.getLocationCoordinates() ) );

        return warehouse;
    }

    protected List<WarehouseNextHopsEntity> warehouseNextHopsListToWarehouseNextHopsEntityList(List<WarehouseNextHops> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHopsEntity> list1 = new ArrayList<WarehouseNextHopsEntity>( list.size() );
        for ( WarehouseNextHops warehouseNextHops : list ) {
            list1.add( warehouseNextHopsMapper.dtoToEntity( warehouseNextHops ) );
        }

        return list1;
    }

    protected List<WarehouseNextHops> warehouseNextHopsEntityListToWarehouseNextHopsList(List<WarehouseNextHopsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHops> list1 = new ArrayList<WarehouseNextHops>( list.size() );
        for ( WarehouseNextHopsEntity warehouseNextHopsEntity : list ) {
            list1.add( warehouseNextHopsMapper.entityToDto( warehouseNextHopsEntity ) );
        }

        return list1;
    }
}
