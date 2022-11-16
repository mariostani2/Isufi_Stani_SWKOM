package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class WarehouseNextHopsEntity {

    @NotNull
    private Integer traveltimeMins;

    @NotNull
    private HopEntity hop;
}
