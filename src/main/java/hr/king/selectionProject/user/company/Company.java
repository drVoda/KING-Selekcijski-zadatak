package hr.king.selectionProject.user.company;

import hr.king.selectionProject.user.User;
import hr.king.selectionProject.user.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long companyId;

    private String department;
    private String name;
    private String title;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(mappedBy = "company")
    private User user;
}
