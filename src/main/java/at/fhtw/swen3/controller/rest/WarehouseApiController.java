package at.fhtw.swen3.controller.rest;




import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-24T08:44:03.675534Z[Etc/UTC]")
@Controller
@Slf4j
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @Autowired
    public WarehouseApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    /**
     * GET /warehouse : Exports the hierarchy of Warehouse and Truck objects.
     *
     * @return Successful response (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or No hierarchy loaded yet. (status code 404)
     */
    @Override
    public ResponseEntity<Warehouse> exportWarehouses() {

        try{
            WarehouseEntity warehouseEntity = warehouseService.exportWarehouses();
            Warehouse warehouseDto = WarehouseMapper.INSTANCE.entityToDto(warehouseEntity);
            return ResponseEntity.ok(warehouseDto);
        } catch (DALException e) {
            return ResponseEntity.status(404).body(null);
        }

    }

    /**
     * GET /warehouse/{code} : Get a certain warehouse or truck by code
     *
     * @param code (required)
     * @return Successful response (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or No hop with the specified id could be found. (status code 404)
     */
    @Override
    public ResponseEntity<Hop> getWarehouse(String code) {
        try{
            HopEntity hopEntity=warehouseService.getWarehouse(code);
            return ResponseEntity.ok(HopMapper.INSTANCE.entityToDto(hopEntity));
        } catch (DALException e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    /**
     * POST /warehouse : Imports a hierarchy of Warehouse and Truck objects.
     *
     * @param warehouse (required)
     * @return Successfully loaded. (status code 200)
     * or The operation failed due to an error. (status code 400)
     */
    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse) {
        try{
            WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);
            warehouseService.importWarehouse(warehouseEntity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DALException e) {
            return ResponseEntity.status(400).body(null);
        }

    }
}
