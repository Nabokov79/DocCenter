package ru.nabokovsg.adminservice.models.addresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(city, address.city) && Objects.equals(typeBuilding, address.typeBuilding) && Objects.equals(login, address.login) && Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(buildingNumber, address.buildingNumber) && Objects.equals(letter, address.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, typeBuilding, login, street, houseNumber, buildingNumber, letter);
    }
}
