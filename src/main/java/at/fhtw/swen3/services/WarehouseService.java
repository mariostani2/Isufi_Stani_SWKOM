package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("warehouseService")
public interface WarehouseService{

    Optional<WarehouseEntity> exportWarehouses();
    HopEntity getWarehouse(String code);
    void importWarehouse(WarehouseEntity warehouse);
}
