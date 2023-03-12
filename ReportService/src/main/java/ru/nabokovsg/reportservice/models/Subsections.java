package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

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
    @Column(name = "number")
    private Double number;
    @Column(name = "heading")
    private String heading;
    @Column(name = "text")
    private String text;
    @Column(name = "paragraph")
    private String paragraph;
    @Column(name = "place")
    private String place;
    @Column(name = "deviation_size")
    private String deviationSize;
    @Column(name = "conclusion")
    private String conclusion;
    @OneToMany(mappedBy = "subsections",cascade = CascadeType.ALL)
    private List<Tables> tables;
    @ManyToOne
    @JoinColumn(name = "sections_id")
    @JsonIgnore
    private Sections sections;
}
