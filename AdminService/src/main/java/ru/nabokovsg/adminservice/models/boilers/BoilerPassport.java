package ru.nabokovsg.adminservice.models.boilers;

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
@Table(name = "boiler_passports")
public class BoilerPassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "boiler_id", referencedColumnName = "id")
    private Boiler boiler;
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
    @Column(name = "operation")
    private LocalDate operation;
    @Column(name = "start_passport")
    private LocalDate startPassport;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "boiler_passports_surveys",
            joinColumns =  {@JoinColumn(name = "boiler_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "surveys_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "boiler_passports_repairs",
            joinColumns =  {@JoinColumn(name = "boiler_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repairs_id")})
    @ToString.Exclude
    private List<Repair> repairs;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "boiler_passports_documentations",
            joinColumns =  {@JoinColumn(name = "boiler_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "documentations_id")})
    @ToString.Exclude
    private List<Documentation> documentation;
}
