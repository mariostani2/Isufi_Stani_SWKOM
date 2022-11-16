package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class WarehouseEntity extends HopEntity {

    @NotNull
    private Integer level;

    @NotNull
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
