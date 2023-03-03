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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "combined_columns_id", referencedColumnName = "id")
    private CombinedColumns combinedColumns;
    @OneToMany(mappedBy = "tables", fetch = FetchType.LAZY)
    private Set<TableColumns> tableColumns;

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", combinedColumns=" + combinedColumns +
                ", tableColumns=" + tableColumns +
                '}';
    }
}
