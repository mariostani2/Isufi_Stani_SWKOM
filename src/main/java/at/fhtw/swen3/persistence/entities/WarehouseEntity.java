package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
public class WarehouseEntity extends HopEntity {


    @Column
    @NotNull
    private Integer level;

    @OneToMany
    @NotNull
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
