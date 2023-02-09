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
@Table(name = "tank_parameters")
public class TankParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_tank")
    @Enumerated(EnumType.STRING)
    private TypeTank typeTank;
    @Column(name = "orientation")
    @Enumerated(EnumType.STRING)
    private Orientation orientation;
    @Column(name = "volume")
    private Integer volume;
}
