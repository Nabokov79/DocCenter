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
@Table(name = "elements")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PatternType type;
    @Column(name = "point")
    private Integer point;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private List<Defect> defects;
    @Column(name = "is_no_defect")
    private String noDefect;
    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private List<SubElement> subElements;
    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonIgnore
    private Tables table;
}
