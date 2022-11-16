package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class HopEntity {

    @NotNull
    private String hopType;

    @NotNull
    private String code;

    @NotNull
    private String description;

    @NotNull
    private Integer processingDelayMins;

    @NotNull
    private String locationName;

    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
