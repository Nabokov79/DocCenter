package ru.nabokovsg.adminservice.models.boilers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "boilers")
public class Boiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "type")
    private String type;
    @Column(name = "model")
    private String model;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boiler boiler = (Boiler) o;
        return id == boiler.id && Objects.equals(number, boiler.number) && Objects.equals(type, boiler.type) && Objects.equals(model, boiler.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, type, model);
    }
}
