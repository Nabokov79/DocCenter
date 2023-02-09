package ru.nabokovsg.adminservice.models.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.Manufacturer;
import ru.nabokovsg.adminservice.models.Organization;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "measuring_tools")
public class MeasuringTool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "work_number")
    private Integer workNumber;
    @Column(name = "purpose")
    private String purpose;
    @Column(name = "manufacturing")
    private LocalDate manufacturing;
    @Column(name = "exploitation")
    private LocalDate exploitation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturer;
    @Column(name = "measuring_range")
    private String  measuringRange;
    @Column(name = "characteristics")
    private String characteristics;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
    @Column(name = "verification_date")
    private LocalDate verificationDate;
    @Column(name = "next_verification_date")
    private LocalDate nextVerificationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;
    @Column(name = "certificate_number")
    private String certificateNumber;
    @Column(name = "registry")
    private String registry;
    @Column(name = "note")
    private String note;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "control_type_id", referencedColumnName = "id")
    private ControlType type;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;

}
