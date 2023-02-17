package ru.nabokovsg.adminservice.models.pipelines;

import lombok.*;
import ru.nabokovsg.adminservice.models.Type;
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
@Table(name = "oil_pipeline_passports")
public class OilPipelinePassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @Column(name = "project_number")
    private String projectNumber;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "mounting_id", nullable = false)
    private Mounting mounting;
    @Column(name = "installation")
    private LocalDate installation;
    @Column(name = "operation")
    private LocalDate operation;
    @Column(name = "start_passport")
    private LocalDate startPassport;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "oil_pipeline_passports_standard_norm_pipes",
            joinColumns =  {@JoinColumn(name = "oil_pipeline_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "standard_norm_pipe_id")})
    @ToString.Exclude
    private List<StandardNormPipe> standardNormPipes;
    @Column(name = "direct_pressure")
    private String directPressure;
    @Column(name = "direct_temperature")
    private String directTemperature;
    @Column(name = "back_pressure")
    private String backPressure;
    @Column(name = "back_temperature")
    private String backTemperature;
    @Column(name = "temperature")
    private String temperature;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "oil_pipeline_passports_surveys",
            joinColumns =  {@JoinColumn(name = "oil_pipeline_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "surveys_id")})
    @ToString.Exclude
    private List<Survey> surveys;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "oil_pipeline_passports_repairs",
            joinColumns =  {@JoinColumn(name = "oil_pipeline_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "repairs_id")})
    @ToString.Exclude
    private List<Repair> repairs;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "oil_pipeline_passports_documentations",
            joinColumns =  {@JoinColumn(name = "oil_pipeline_passport_id")},
            inverseJoinColumns = {@JoinColumn(name = "documentations_id")})
    @ToString.Exclude
    private List<Documentation> documentations;
}
