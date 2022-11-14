package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class ParcelEntity {
    @DecimalMin("0.0")
    private Float weight;
    @NotNull(message ="recipient cannot be NULL")
    private RecipientEntity recipient;
    @NotNull(message ="sender cannot be NULL")
    private RecipientEntity sender;

    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    @NotNull(message ="state cannot be NULL")
    private TrackingInformation.StateEnum state;
    @NotNull(message ="visitedHops cannot be NULL")
    private List<HopArrival> visitedHops;
    @NotNull(message ="futureHops cannot be NULL")
    private List<HopArrival> futureHops;
}
