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
@Table(name = "protocols")
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "name")
    private String name;
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
    @OneToMany(mappedBy = "protocol", fetch = FetchType.LAZY)
    private List<Tables> table;
    @ManyToOne
    @JoinColumn(name = "sections_id")
    @JsonIgnore
    private Sections sections;
}
