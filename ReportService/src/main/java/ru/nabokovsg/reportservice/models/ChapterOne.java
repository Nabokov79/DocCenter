package ru.nabokovsg.reportservice.models;

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
@Table(name = "chapter_one")
public class ChapterOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "one_subsection")
    private String oneSubsection;
    @Column(name = "one_subsection_text")
    private String oneSubsectionText;
    @Column(name = "second_subsection")
    private String secondSubsection;
    @Column(name = "three_subsection")
    private String threeSubsection;
}
