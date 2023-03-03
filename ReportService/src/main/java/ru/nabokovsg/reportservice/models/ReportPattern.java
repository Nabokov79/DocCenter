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
@Table(name = "report_patterns")
public class ReportPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "pattern_type")
    @Enumerated(EnumType.STRING)
    private PatternType patternType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id", referencedColumnName = "id")
    private Title title;
    @OneToMany(mappedBy = "reportPattern", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Sections> sections;

    @Override
    public String toString() {
        return "ReportPattern{" +
                "id=" + id +
                ", patternType=" + patternType +
                ", title=" + title +
                ", sections=" + sections +
                '}';
    }
}
