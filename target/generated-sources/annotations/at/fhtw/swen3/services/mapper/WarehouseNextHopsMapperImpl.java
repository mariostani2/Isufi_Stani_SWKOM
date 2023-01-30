package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity.WarehouseNextHopsEntityBuilder;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T22:55:17+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class WarehouseNextHopsMapperImpl implements WarehouseNextHopsMapper {

    private final HopMapper hopMapper = Mappers.getMapper( HopMapper.class );

    @Override
    public WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops warehouseNextHopsDto) {
        if ( warehouseNextHopsDto == null ) {
            return null;
        }

        WarehouseNextHopsEntityBuilder warehouseNextHopsEntity = WarehouseNextHopsEntity.builder();

        warehouseNextHopsEntity.hop( hopMapper.dtoToEntity( warehouseNextHopsDto.getHop() ) );
        warehouseNextHopsEntity.traveltimeMins( warehouseNextHopsDto.getTraveltimeMins() );

        return warehouseNextHopsEntity.build();
    }

    @Override
    public WarehouseNextHops entityToDto(WarehouseNextHopsEntity warehouseNextHopsEntity) {
        if ( warehouseNextHopsEntity == null ) {
            return null;
        }

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setHop( hopMapper.entityToDto( warehouseNextHopsEntity.getHop() ) );
        warehouseNextHops.setTraveltimeMins( warehouseNextHopsEntity.getTraveltimeMins() );

        return warehouseNextHops;
    }
}
