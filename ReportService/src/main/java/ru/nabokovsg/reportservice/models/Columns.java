package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "columns")
public class Columns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonIgnore
    private Tables table;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "combined_columns_id", referencedColumnName = "id")
    private CombinedColumns combinedColumns;
}
