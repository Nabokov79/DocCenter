package ru.nabokovsg.adminservice.models.pipelines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Type;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "standard_norm_pipes")
public class StandardNormPipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "thickness")
    private Float thickness;
    @Column(name = "min")
    private Float min;

    @Override
    public String toString() {
        return "StandardNormPipe{" +
                "id=" + id +
                ", type=" + type +
                ", diameter=" + diameter +
                ", thickness=" + thickness +
                ", min=" + min +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardNormPipe that = (StandardNormPipe) o;
        return id == that.id && Objects.equals(type, that.type) && Objects.equals(diameter, that.diameter) && Objects.equals(thickness, that.thickness) && Objects.equals(min, that.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, diameter, thickness, min);
    }
}
