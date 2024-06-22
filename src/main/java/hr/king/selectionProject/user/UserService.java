package hr.king.selectionProject.user;

import hr.king.selectionProject.user.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public void saveUser(User user) {
        if (user.getCompany() != null) {
            companyRepository.save(user.getCompany());
        }

        userRepository.save(user);
    }

    public void saveUsers(List<User> users) {
        for (User user : users) {
            saveUser(user);
        }
    }
}

