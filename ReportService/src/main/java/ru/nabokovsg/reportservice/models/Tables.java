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
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private Set<Columns> columns;
    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private Set<SubTable> subTables;
    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private Set<Element> elements;
}
