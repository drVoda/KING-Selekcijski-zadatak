package hr.king.selectionProject.user.address;

import hr.king.selectionProject.user.User;
import hr.king.selectionProject.user.address.coordinates.Coordinates;
import hr.king.selectionProject.user.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private Coordinates coordinates;

    private String country;

    @OneToOne(mappedBy = "address")
    private Company company;

    @OneToOne(mappedBy = "address")
    private User user;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        coordinates.setAddress(this);
    }
}
