package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subsections")
public class Subsections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Columns(name = "number")
    private Double number;
    @Columns(name = "heading")
    private String heading;
    @Columns(name = "text")
    private String text;
    @Columns(name = "paragraph")
    private String paragraph;
    @Columns(name = "place")
    private String place;
    @Columns(name = "deviation_size")
    private String deviationSize;
    @Columns(name = "conclusion")
    private String conclusion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tables_id", referencedColumnName = "id")
    private Tables tables;
    @ManyToOne
    @JoinColumn(name = "sections_id")
    @JsonIgnore
    private Sections sections;

    @Override
    public String toString() {
        return "Subsections{" +
                "id=" + id +
                ", number=" + number +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", tables=" + tables +
                ", sections=" + sections +
                '}';
    }
}
