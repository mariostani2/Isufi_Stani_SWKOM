package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper extends BaseMapper<TransferWarehouseEntity, Transferwarehouse>{
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);
}
