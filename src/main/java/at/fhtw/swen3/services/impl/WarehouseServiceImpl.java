package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private final WarehouseRepository warehouseRepository;
    @Autowired
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Autowired
    private HopRepository hopRepository;
    @Autowired
    private TruckRepository truckRepository;


    @Autowired
    private TransferwarehouseRepository transferwarehouseRepository;
    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;

    private void dropDB() {

        warehouseNextHopsRepository.deleteAll();
        warehouseRepository.deleteAll();

    }


    @Override
    public Optional<WarehouseEntity> exportWarehouses() {

        return warehouseRepository.getFirstByLevel(0);
    }

    @Override
    public HopEntity getWarehouse(String code) {
        var result = hopRepository.getFirstByCode(code);
        return result.get();
    }

    @Override
    public void importWarehouse(WarehouseEntity warehouseEntity) {
        dropDB();
        warehouseRepository.save(warehouseEntity);
    }




}
