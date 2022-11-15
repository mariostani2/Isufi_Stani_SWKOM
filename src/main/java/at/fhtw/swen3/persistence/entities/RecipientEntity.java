package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Address;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Optional;
import java.util.Set;


@Getter @Setter
public class RecipientEntity {
    @NotNull(message = "Country cannot be null")
    private String country;
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\\s0-9-]+$")
    private String name;
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Za-z]+\\s[A-Za-z\\d/]+$")
    private String street;
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^(A-)\\d{4}$")
    private String postalCode;
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\\s0-9-]+$")
    private String city;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

     public boolean isValid(){
         if (getCountry() == "Österreich" || getCountry() =="Austria"){
             Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(this);
             for (ConstraintViolation<RecipientEntity> violation : violations) {
              System.out.println(violation.getMessage());
    }
             return violations.isEmpty();
         }
         else  return true;
     }

}
