package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("warehouseService")
public interface WarehouseService{

    List<WarehouseEntity> exportWarehouses();
}
