package at.fhtw.swen3.persistence.entities;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class GeoCoordinateEntity {
    @NotNull
    private Double lat;

    @NotNull
    private Double lon;
}
