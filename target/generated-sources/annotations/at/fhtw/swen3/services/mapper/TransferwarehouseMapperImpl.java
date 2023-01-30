package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity.TransferwarehouseEntityBuilder;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T22:55:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    private final GeoCoordinateMapper geoCoordinateMapper = Mappers.getMapper( GeoCoordinateMapper.class );

    @Override
    public TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouseDto) {
        if ( transferwarehouseDto == null ) {
            return null;
        }

        TransferwarehouseEntityBuilder<?, ?> transferwarehouseEntity = TransferwarehouseEntity.builder();

        transferwarehouseEntity.logisticsPartnerUrl( transferwarehouseDto.getLogisticsPartnerUrl() );
        transferwarehouseEntity.logisticsPartner( transferwarehouseDto.getLogisticsPartner() );
        transferwarehouseEntity.regionGeoJson( transferwarehouseDto.getRegionGeoJson() );
        transferwarehouseEntity.hopType( transferwarehouseDto.getHopType() );
        transferwarehouseEntity.code( transferwarehouseDto.getCode() );
        transferwarehouseEntity.description( transferwarehouseDto.getDescription() );
        transferwarehouseEntity.processingDelayMins( transferwarehouseDto.getProcessingDelayMins() );
        transferwarehouseEntity.locationName( transferwarehouseDto.getLocationName() );
        transferwarehouseEntity.locationCoordinates( geoCoordinateMapper.dtoToEntity( transferwarehouseDto.getLocationCoordinates() ) );

        return transferwarehouseEntity.build();
    }

    @Override
    public Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity) {
        if ( transferwarehouseEntity == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setLogisticsPartnerUrl( transferwarehouseEntity.getLogisticsPartnerUrl() );
        transferwarehouse.setLogisticsPartner( transferwarehouseEntity.getLogisticsPartner() );
        transferwarehouse.setRegionGeoJson( transferwarehouseEntity.getRegionGeoJson() );
        transferwarehouse.hopType( transferwarehouseEntity.getHopType() );
        transferwarehouse.code( transferwarehouseEntity.getCode() );
        transferwarehouse.description( transferwarehouseEntity.getDescription() );
        transferwarehouse.processingDelayMins( transferwarehouseEntity.getProcessingDelayMins() );
        transferwarehouse.locationName( transferwarehouseEntity.getLocationName() );
        transferwarehouse.locationCoordinates( geoCoordinateMapper.entityToDto( transferwarehouseEntity.getLocationCoordinates() ) );

        return transferwarehouse;
    }
}
