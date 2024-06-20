package hr.king.selectionProject.user.company;

import hr.king.selectionProject.user.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String department;
    private String name;
    private String title;
    private Address address;
}
