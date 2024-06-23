package hr.king.selectionProject.user.address.coordinates;

import hr.king.selectionProject.user.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Coordinates {

    @Id
    private long id;

    private double lat;
    private double lng;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Address address;
}
