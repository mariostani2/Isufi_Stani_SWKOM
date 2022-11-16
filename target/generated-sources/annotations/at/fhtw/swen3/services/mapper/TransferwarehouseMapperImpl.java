package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-16T20:34:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferWarehouseEntity author) {
        if ( author == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setRegionGeoJson( author.getRegionGeoJson() );
        transferwarehouse.setLogisticsPartner( author.getLogisticsPartner() );
        transferwarehouse.setLogisticsPartnerUrl( author.getLogisticsPartnerUrl() );

        return transferwarehouse;
    }

    @Override
    public TransferWarehouseEntity dtoToEntity(Transferwarehouse authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        TransferWarehouseEntity transferWarehouseEntity = new TransferWarehouseEntity();

        transferWarehouseEntity.setRegionGeoJson( authorDto.getRegionGeoJson() );
        transferWarehouseEntity.setLogisticsPartner( authorDto.getLogisticsPartner() );
        transferWarehouseEntity.setLogisticsPartnerUrl( authorDto.getLogisticsPartnerUrl() );

        return transferWarehouseEntity;
    }
}
