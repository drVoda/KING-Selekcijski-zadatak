package hr.king.selectionProject.user;

import hr.king.selectionProject.user.address.Address;
import hr.king.selectionProject.user.address.AddressRepository;
import hr.king.selectionProject.user.address.coordinates.Coordinates;
import hr.king.selectionProject.user.address.coordinates.CoordinatesRepository;
import hr.king.selectionProject.user.bank.Bank;
import hr.king.selectionProject.user.company.Company;
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
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CoordinatesRepository coordinatesRepository;

    public void saveUser(User user) {


        Address addressPersisted = addressRepository.save(user.getAddress());
        user.setAddress(addressPersisted);
        user.getAddress().getCoordinates().setId(user.getAddress().getId());

        Coordinates userCoordinatesPersisted = coordinatesRepository.save(user.getAddress().getCoordinates());
        user.getAddress().setCoordinates(userCoordinatesPersisted);

        Address companyAddress = addressRepository.save(user.getCompany().getAddress());
        user.getCompany().setAddress(companyAddress);
        user.getCompany().getAddress().getCoordinates().setId(user.getCompany().getAddress().getId());

        Coordinates companyCoordinatesPersisted = coordinatesRepository.save(user.getCompany().getAddress().getCoordinates());
        user.getCompany().getAddress().setCoordinates(companyCoordinatesPersisted);

        Company companyPersisted = companyRepository.save(user.getCompany());
        user.setCompany(companyPersisted);

        userRepository.save(user);
    }

    public void saveUsers(List<User> users) {
        for (User user : users) {
            saveUser(user);
        }
    }
}

