package at.fhtw.swen3.persistence.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Getter @Setter
@Entity
@Table(name = "recipient")
public class RecipientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;

    @Column
    @NotNull(message = "Country cannot be null")
    private String country;

    @Column
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\\s0-9-]+$")
    private String name;

    @Column
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Za-z]+\\s[A-Za-z\\d/]+$")
    private String street;

    @Column
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^(A-)\\d{4}$")
    private String postalCode;

    @Column
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\\s0-9-]+$")
    private String city;



    @AssertTrue
     public boolean isValid(){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        if (getCountry() == "Österreich" || getCountry() =="Austria"){
             Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(this);
             for (ConstraintViolation<RecipientEntity> violation : violations) {
              System.out.println(violation.getMessage());
    }
             return violations.isEmpty();
         }
         else  return true;
     }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
