package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-17T00:02:46+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferWarehouseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setRegionGeoJson( entity.getRegionGeoJson() );
        transferwarehouse.setLogisticsPartner( entity.getLogisticsPartner() );
        transferwarehouse.setLogisticsPartnerUrl( entity.getLogisticsPartnerUrl() );

        return transferwarehouse;
    }

    @Override
    public TransferWarehouseEntity dtoToEntity(Transferwarehouse dto) {
        if ( dto == null ) {
            return null;
        }

        TransferWarehouseEntity transferWarehouseEntity = new TransferWarehouseEntity();

        transferWarehouseEntity.setRegionGeoJson( dto.getRegionGeoJson() );
        transferWarehouseEntity.setLogisticsPartner( dto.getLogisticsPartner() );
        transferWarehouseEntity.setLogisticsPartnerUrl( dto.getLogisticsPartnerUrl() );

        return transferWarehouseEntity;
    }
}
