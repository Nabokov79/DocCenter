package ru.nabokovsg.reportservice.models;

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
@Table(name = "combined_columns")
public class CombinedColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "column_first")
    private Integer columnFirst;
    @Column(name = "column_second")
    private Integer columnSecond;
    @Column(name = "name")
    private String name;
}
