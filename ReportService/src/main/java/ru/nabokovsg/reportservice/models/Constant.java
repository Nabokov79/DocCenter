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
@Table(name = "constants")
public class Constant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "document")
    private String document;
    @Column(name = "number")
    private Double number;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @Column(name = "paragraph")
    private String paragraph;
    @Column(name = "place")
    private String place;
    @Column(name = "deviation_size")
    private String deviationSize;
    @Column(name = "conclusion")
    private String conclusion;
}
