package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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
    @Column(name = "text")
    private String text;
    @OneToMany(mappedBy = "table")
    private List<Columns> columns;
    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private List<SubTable> subTables;
    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private List<Element> elements;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subsections_id",  nullable = false)
    @JsonIgnore
    private Subsections subsections;

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", columns=" + columns +
                ", subTables=" + subTables +
                ", elements=" + elements +
                ", subsections=" + subsections +
                '}';
    }
}
