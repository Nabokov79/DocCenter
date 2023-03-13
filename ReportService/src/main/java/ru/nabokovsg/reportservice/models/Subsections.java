package ru.nabokovsg.reportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subsections")
public class Subsections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number")
    private Double number;
    @Column(name = "heading")
    private String heading;
    @Column(name = "text")
    private String text;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private Tables table;
    @ManyToOne
    @JoinColumn(name = "sections_id")
    @JsonIgnore
    private Sections sections;
}
