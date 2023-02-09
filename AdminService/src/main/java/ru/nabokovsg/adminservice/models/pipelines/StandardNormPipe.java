package ru.nabokovsg.adminservice.models.pipelines;

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
@Table(name = "standard_norm_pipes")
public class StandardNormPipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purpose_pipeline_id", referencedColumnName = "id")
    private PurposePipeline purpose;
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
                ", purpose=" + purpose +
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
        return id == that.id && purpose == that.purpose && Objects.equals(diameter, that.diameter) && Objects.equals(thickness, that.thickness) && Objects.equals(min, that.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purpose, diameter, thickness, min);
    }
}
