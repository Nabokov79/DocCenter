package ru.nabokovsg.adminservice.models.filters;

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
@Table(name = "filter_passports")
public class FilterPassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filter_id", referencedColumnName = "id")
    private Filter filter;
    @Column(name = "number_filter")
    private Integer numberFilter;
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
    @Column(name = "estimated_life")
    private Integer estimatedLife;
    @Column(name = "operation")
    private LocalDate operation;
    @Column(name = "volume")
    private Integer volume;
    @Column(name = "start_passport")
    private LocalDate startPassport;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dimensions_id", referencedColumnName = "id")
    private Dimensions dimensions;
    @Column(name = "orientation")
    private String orientation;
    @Column(name = "pressure")
    private Integer pressure;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "filter_passports_surveys",
            joinColumns =  {@JoinColumn(name = "filter_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "surveys_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "filter_passports_repairs",
            joinColumns =  {@JoinColumn(name = "filter_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repairs_id")})
    @ToString.Exclude
    private List<Repair> repairs;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "filter_passports_documentations",
            joinColumns =  {@JoinColumn(name = "filter_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "documentations_id")})
    @ToString.Exclude
    private List<Documentation> documentation;
}
