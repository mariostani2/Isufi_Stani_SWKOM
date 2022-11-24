package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Getter @Setter
@Entity
@Table(name="hopArrival")
public class HopArrivalEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    @Column
    private String code;
    @NotNull
    @Column
    private String description;
    @PastOrPresent
    @Column
    private OffsetDateTime dateTime;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
