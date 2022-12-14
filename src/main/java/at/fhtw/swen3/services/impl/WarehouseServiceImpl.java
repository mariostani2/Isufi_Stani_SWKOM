package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private final WarehouseRepository warehouseRepository;


    @Override
    public List<WarehouseEntity> exportWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public HopEntity getWarehouse(String code) {
        var result = warehouseRepository.findByCode(code);
        return result.size()>0 ?  warehouseRepository.findByCode(code).get(0) : null;
    }

    @Override
    public void importWarehouse(WarehouseEntity warehouseEntity) {
        warehouseRepository.save(warehouseEntity);
    }

}
