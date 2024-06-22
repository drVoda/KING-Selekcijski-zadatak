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
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String department;
    private String name;
    private String title;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    private User user;
}
