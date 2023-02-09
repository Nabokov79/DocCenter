package ru.nabokovsg.adminservice.models.tanks;

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
@Table(name = "bottoms")
public class Bottom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "number_bottom")
    private Integer numberBottom;
    @Column(name = "thickness_bottom")
    private Integer thicknessBottom;
    @Column(name = "norm_bottom")
    private Float normBottom;
    @Column(name = "thickness_edge")
    private Integer thicknessEdge;
    @Column(name = "norm_edge")
    private Float normEdge;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tank_parameters_id", referencedColumnName = "id")
    private TankParameters tankParameters;
}
