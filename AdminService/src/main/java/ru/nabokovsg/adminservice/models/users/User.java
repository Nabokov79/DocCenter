package ru.nabokovsg.adminservice.models.users;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "post", nullable = false)
    private String post;
    @Column(name = "service_number")
    private Integer serviceNumber;
    @OneToMany(mappedBy = "user",
            orphanRemoval = true,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Certificate> certificate = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MeasuringTool> measuringTool = new HashSet<>();
}
