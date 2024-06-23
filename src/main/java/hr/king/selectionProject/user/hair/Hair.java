package hr.king.selectionProject.user.hair;

import hr.king.selectionProject.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Hair {

    private String color;
    private String type;
}
