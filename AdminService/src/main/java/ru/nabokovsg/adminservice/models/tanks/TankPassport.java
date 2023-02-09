package ru.nabokovsg.adminservice.models.tanks;

import lombok.*;
import ru.nabokovsg.adminservice.models.*;
import ru.nabokovsg.adminservice.models.addresses.Address;
import ru.nabokovsg.adminservice.models.documentation.Documentation;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tank_passports")
public class TankPassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tank_number")
    private Integer tankNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tank_parameters_id", referencedColumnName = "id")
    private TankParameters tankParameters;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @Column(name = "project_number")
    private String projectNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mounting_id", referencedColumnName = "id")
    private Mounting mounting;
    @Column(name = "installation")
    private LocalDate installation;
    @Column(name = "operation")
    private LocalDate operation;
    @Column(name = "start_passport")
    private LocalDate startPassport;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dimensions_id", referencedColumnName = "id")
    private Dimensions dimensions;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_passports_belts",
            joinColumns =  {@JoinColumn(name = "tank_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "belt_id")})
    @ToString.Exclude
    private List<Belt> belts;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_passports_bottoms",
            joinColumns =  {@JoinColumn(name = "tank_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "bottom_id")})
    @ToString.Exclude
    private List<Bottom> bottoms;
    @Column(name = "height_pipe")
    private Float heightPipe;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "protections_id", referencedColumnName = "id")
    private Protections protections;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_passports_surveys",
            joinColumns =  {@JoinColumn(name = "tank_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "surveys_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_passports_repairs",
            joinColumns =  {@JoinColumn(name = "tank_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repairs_id")})
    @ToString.Exclude
    private List<Repair> repairs;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tank_passports_documentations",
            joinColumns =  {@JoinColumn(name = "tank_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "documentations_id")})
    @ToString.Exclude
    private List<Documentation> documentation;
}
