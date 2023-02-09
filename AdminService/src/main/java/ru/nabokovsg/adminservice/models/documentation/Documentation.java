package ru.nabokovsg.adminservice.models.documentation;

import javax.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documentations")
public class Documentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type_object", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeObject typeObject;
    @Column(name = "type_document", nullable = false)
    private String typeDocument;
    @Column(name = "number_document", nullable = false)
    private String numberDocument;
    @Column(name = "title", nullable = false)
    private String title;
}
