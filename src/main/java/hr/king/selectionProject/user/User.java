package hr.king.selectionProject.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import hr.king.selectionProject.user.address.Address;
import hr.king.selectionProject.user.bank.Bank;
import hr.king.selectionProject.user.company.Company;
import hr.king.selectionProject.user.crypto.Crypto;
import hr.king.selectionProject.user.hair.Hair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String image;
    private String bloodGroup;
    private double height;
    private double weight;
    private String eyeColor;
    private Hair hair;
    private String ip;
    private Address address;
    private String macAddress;
    private String university;
    private Bank bank;
    private Company company;
    private String ein;
    private String ssn;
    private String userAgent;
    private Crypto crypto;
    private String role;
}
