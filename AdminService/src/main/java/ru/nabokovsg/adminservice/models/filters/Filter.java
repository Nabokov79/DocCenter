package ru.nabokovsg.adminservice.models.filters;

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
@Table(name = "filters")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
}
