package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "parcel")
public class ParcelEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;


    @DecimalMin("0.0")
    @Column
    private Float weight;

    @JoinColumn
    @NotNull(message ="recipient cannot be NULL")
    @OneToOne
    private RecipientEntity recipient;

    @JoinColumn
    @OneToOne
    @NotNull(message ="sender cannot be NULL")
    private RecipientEntity sender;

    @Column
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

    @Column
    @NotNull(message ="state cannot be NULL")
    private TrackingInformation.StateEnum state;


    @Column
    @NotNull(message ="visitedHops cannot be NULL")
    @ManyToMany (cascade =CascadeType.ALL)
    private List<HopArrivalEntity> visitedHops;

    @Column
    @NotNull(message ="futureHops cannot be NULL")
    @ManyToMany(targetEntity=HopArrivalEntity.class)
    private List<HopArrivalEntity> futureHops;

    public <E> ParcelEntity(Long v, RecipientEntity recipient, RecipientEntity recipientEntity, String rd4343, TrackingInformation.StateEnum delivered, LinkedList<E> es, LinkedList<E> es1) {
    }


    @AssertTrue
    private boolean validate(){
        if(recipient.isValid() && sender.isValid())
        {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(this);
            for (ConstraintViolation<ParcelEntity> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return violations.isEmpty();
        }

        return false;

    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}

