package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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
    @Column(name = "point")
    private Integer point;
    @Column(name = "name")
    private String name;
    @Column(name = "is_no_defect")
    private String isNoDefect;
    @OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
    private Set<Defect> defect;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "elements_sub_elements",
            joinColumns =  {@JoinColumn(name = "elements_id")},
            inverseJoinColumns = {@JoinColumn(name = "sub_elements_id")})
    @ToString.Exclude
    private List<SubElement> subElements;
    @ManyToOne
    @JoinColumn(name = "sub_table_id")
    @JsonIgnore
    private SubTable subTable;
    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonIgnore
    private Tables tables;
}
