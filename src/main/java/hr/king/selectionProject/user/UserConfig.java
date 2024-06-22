package hr.king.selectionProject.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserService userService) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://dummyjson.com/users";

            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

            if (response.getBody() != null) {

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    UserResponse userResponse = objectMapper.readValue(response.getBody(), UserResponse.class);
                    if (userResponse.getUsers() != null) {
                        userService.saveUsers(userResponse.getUsers());
                        System.out.println("Users saved successfully");
                    } else {
                        System.out.println("No users found in the API response");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error parsing JSON response");
                }
            } else {
                System.out.println("No response body found");
            }
        };
    }
}
