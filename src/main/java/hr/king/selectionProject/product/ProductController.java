package hr.king.selectionProject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/getAll")
    public List<ProductSummary> getProducts() {
        List<Product> products = productService.getAllProducts();

        return products.stream()
                .map(product -> new ProductSummary(
                        product.getThumbnail(),
                        product.getTitle(),
                        product.getPrice(),
                        product.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        long productId;
        try {
            productId = Long.parseLong(id);
        }
        catch (NumberFormatException e) {
            throw new ProductNotFoundException("Please provide a valid product id - it should be a number");
        }

        return productService.getProductById(productId);
    }
}
