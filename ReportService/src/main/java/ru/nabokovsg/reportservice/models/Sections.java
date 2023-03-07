package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sections")
public class Sections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "heading")
    private String heading;
    @OneToMany(mappedBy = "sections", fetch = FetchType.LAZY)
    private Set<Subsections> subsections;
    @OneToMany(mappedBy = "sections", fetch = FetchType.LAZY)
    private Set<Drawing> drawings;
    @ManyToOne
    @JoinColumn(name = "report_pattern_id")
    @JsonIgnore
    private ReportPattern reportPattern;

    @Override
    public String toString() {
        return "Sections{" +
                "id=" + id +
                ", number=" + number +
                ", heading='" + heading + '\'' +
                ", subsections=" + subsections +
                ", drawings=" + drawings +
                '}';
    }
}
