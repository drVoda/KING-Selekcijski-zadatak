package hr.king.selectionProject.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
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

    @GetMapping("/getByPriceAndCategory")
    public List<Product> getByPriceAndCategory(@RequestParam(name = "category", defaultValue = "any") String categorySlug, @RequestParam Optional<String> gt, @RequestParam Optional<String> lt) {
        double priceGt, priceLt;
        try{
            if (gt.isPresent()) {
                priceGt = Double.parseDouble(gt.get());
                if (priceGt < 0){
                    throw new NumberFormatException("Price must be a positive number");
                }
            }

            else{
                priceGt = 0;
            }

            if (lt.isPresent()) {
                priceLt = Double.parseDouble(lt.get());
                if (priceLt < 0){
                    throw new NumberFormatException("Price must be a positive number");
                }
            }
            else{
                priceLt = -1;
            }
        }
        catch (NumberFormatException e) {
            throw new ProductNotFoundException("Please provide valid positive numeric gt and lt arguments");
        }

        return productService.getByPriceAndCategory(categorySlug, priceGt, priceLt);
    }

    @GetMapping("/getByName")
    public List<Product> getByName(@RequestParam(defaultValue = "") String name) {
        if (name.isEmpty()) {
            return productService.getAllProducts();
        }

        return productService.getByName(name);
    }
}
