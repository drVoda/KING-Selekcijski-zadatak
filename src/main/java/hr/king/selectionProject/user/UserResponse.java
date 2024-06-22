package hr.king.selectionProject.user;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private List<User> users;
    private int total, skip, limit;
}
