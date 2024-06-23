package hr.king.selectionProject.user.bank;

import hr.king.selectionProject.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Bank {

    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}
