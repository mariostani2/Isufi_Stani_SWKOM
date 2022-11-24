package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="warehouseNextHops")
public class WarehouseNextHopsEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;

    @Column
    @NotNull
    private Integer traveltimeMins;

    @NotNull
    @OneToOne
    private HopEntity hop;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
