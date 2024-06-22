package hr.king.selectionProject.user;


import hr.king.selectionProject.user.address.Address;
import hr.king.selectionProject.user.bank.Bank;
import hr.king.selectionProject.user.company.Company;
import hr.king.selectionProject.user.crypto.Crypto;
import hr.king.selectionProject.user.hair.Hair;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private double height;
    private double weight;
    private String eyeColor;

    @Embedded
    private Hair hair;

    private String ip;

    @Embedded
    private Address address;

    private String macAddress;
    private String university;

    @Embedded
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Company company;

    private String ein;
    private String ssn;
    private String userAgent;

    @Embedded
    private Crypto crypto;

    private String role;
}
