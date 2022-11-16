package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Getter @Setter
@Entity
public class HopArrivalEntity {

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    @NotNull
    private String description;
    @PastOrPresent
    private OffsetDateTime dateTime;
}
