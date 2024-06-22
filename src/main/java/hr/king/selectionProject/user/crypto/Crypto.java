package hr.king.selectionProject.user.crypto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Crypto {
    private String coin;
    private String wallet;
    private String network;
}
