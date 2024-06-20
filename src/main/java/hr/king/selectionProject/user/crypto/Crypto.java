package hr.king.selectionProject.user.crypto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crypto {
    private String coin;
    private String wallet;
    private String network;
}
