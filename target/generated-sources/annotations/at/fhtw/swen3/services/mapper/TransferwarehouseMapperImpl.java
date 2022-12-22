package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T18:11:44+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferwarehouseEntity entity) {
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
    public TransferwarehouseEntity dtoToEntity(Transferwarehouse dto) {
        if ( dto == null ) {
            return null;
        }

        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity();

        transferwarehouseEntity.setRegionGeoJson( dto.getRegionGeoJson() );
        transferwarehouseEntity.setLogisticsPartner( dto.getLogisticsPartner() );
        transferwarehouseEntity.setLogisticsPartnerUrl( dto.getLogisticsPartnerUrl() );

        return transferwarehouseEntity;
    }
}
