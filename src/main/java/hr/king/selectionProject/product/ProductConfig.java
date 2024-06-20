package hr.king.selectionProject.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://dummyjson.com/products";
            ResponseEntity<ProductResponse> response = restTemplate.getForEntity(apiUrl, ProductResponse.class);

            if (response.getBody() != null) {
                productService.saveProducts(response.getBody().getProducts());
            }
        };
    }
}
