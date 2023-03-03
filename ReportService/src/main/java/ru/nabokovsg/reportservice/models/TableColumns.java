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
public class TableColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "tables_id")
    @JsonIgnore
    private Tables tables;

    @Override
    public String toString() {
        return "TableColumns{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
