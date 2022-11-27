package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="hop")
public class HopEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;

    @NotNull
    @Column
    private String hopType;

    @NotNull
    @Column
    private String code;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private Integer processingDelayMins;

    @NotNull
    @Column
    private String locationName;

    @NotNull
    @OneToOne
    private GeoCoordinateEntity locationCoordinates;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
