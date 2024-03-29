package at.fhtw.swen3.persistence.repositories;


import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseNextHopsRepository  extends JpaRepository<WarehouseNextHopsEntity, Long> {
    Optional<WarehouseNextHopsEntity> findById(Long id);
    WarehouseNextHopsEntity findWarehouseNextHopsEntityByHop_Code(String code);

}
