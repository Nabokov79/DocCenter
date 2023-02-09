package ru.nabokovsg.adminservice.models.addresses;

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
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_building_id", referencedColumnName = "id")
    private TypeBuilding typeBuilding;
    @Column(name = "login")
    private String login;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private Integer houseNumber;
    @Column(name = "building_number")
    private Integer buildingNumber;
    @Column(name = "letter")
    private String letter;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city=" + city +
                ", typeBuilding=" + typeBuilding +
                ", login='" + login + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", buildingNumber=" + buildingNumber +
                ", letter='" + letter + '\'' +
                '}';
    }
}
