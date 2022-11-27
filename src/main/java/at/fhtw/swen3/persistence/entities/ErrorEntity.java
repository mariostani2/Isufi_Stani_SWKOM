package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="error")
public class ErrorEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "AUTO")
    private Long id;
    @Column
    private String errorMessage;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
