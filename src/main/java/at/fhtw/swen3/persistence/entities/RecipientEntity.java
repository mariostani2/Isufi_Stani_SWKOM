package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.Address;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Optional;


@Getter @Setter
public class RecipientEntity {
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "(Austria)||(Österreich)" ,groups = RecipientEntity.class)
    private String country;
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][A-Za-z\\s0-9-]+$")
    private String name;
    @Pattern(regexp = "^[A-Za-z]+\\s[A-Za-z\\d/]+$")
    private String street;
    @Pattern(regexp = "^(A-)\\d{4}$")
    private String postalCode;
    @Pattern(regexp = "^[A-Z][A-Za-z\\s0-9-]+$")
    private String city;

}
