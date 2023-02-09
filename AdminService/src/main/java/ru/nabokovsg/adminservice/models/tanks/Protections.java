package ru.nabokovsg.adminservice.models.tanks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nabokovsg.adminservice.models.documentation.Documentation;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "protections")
public class Protections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentation_id", referencedColumnName = "id")
    private Documentation documentation;
}
