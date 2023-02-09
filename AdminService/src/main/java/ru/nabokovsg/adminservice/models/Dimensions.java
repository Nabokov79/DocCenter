package ru.nabokovsg.adminservice.models;

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
@Table(name = "dimensions")
public class Dimensions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "height_or_length")
    private Integer heightOrLength;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "volume")
    private Integer volume;
}
