package at.fhtw.swen3.persistence.entities;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="geoCoordinate")
public class GeoCoordinateEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;

    @NotNull
    @Column
    private Double lat;

    @NotNull
    @Column
    private Double lon;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
