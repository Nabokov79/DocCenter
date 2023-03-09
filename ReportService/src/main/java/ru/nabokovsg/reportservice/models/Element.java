package ru.nabokovsg.reportservice.models;

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
    private Set<Defect> defects;
    @Column(name = "is_no_defect")
    private String noDefect;
    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private Set<SubElement> subElements;
}
