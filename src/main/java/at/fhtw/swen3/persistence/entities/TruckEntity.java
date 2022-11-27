package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "truck")
public class TruckEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;

    @Column
    @NotNull
    private String regionGeoJson;

    @Column
    @NotNull
    private String numberPlate;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
