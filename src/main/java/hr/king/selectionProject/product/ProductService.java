package hr.king.selectionProject.product;

import hr.king.selectionProject.product.dimensions.DimensionsRepository;
import hr.king.selectionProject.product.meta.MetaRepository;
import hr.king.selectionProject.product.review.Review;
import hr.king.selectionProject.product.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    private final ProductRepository productRepository;

    private final DimensionsRepository dimensionsRepository;

    private final MetaRepository metaRepository;

    private final ReviewRepository reviewRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, DimensionsRepository dimensionsRepository, MetaRepository metaRepository, ReviewRepository reviewRepository){
        this.productRepository = productRepository;
        this.dimensionsRepository = dimensionsRepository;
        this.metaRepository = metaRepository;
        this.reviewRepository = reviewRepository;
    }

    public Product saveProduct(Product product) {
        if (product.getDimensions() != null) {
            dimensionsRepository.save(product.getDimensions());
        }

        if (product.getMeta() != null) {
            metaRepository.save(product.getMeta());
        }

        if (product.getReviews() != null) {
            for (Review review : product.getReviews()) {
                review.setProduct(product);
            }
        }

        return productRepository.save(product);
    }

    public void saveProducts(List<Product> products) {
        for (Product product : products) {
            saveProduct(product);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
    }

    public List<Product> getByPriceAndCategory(String categorySlug, Double priceGt, Double priceLt) {
        return productRepository.findByPriceAndCategory(categorySlug, priceGt, priceLt);
    }
}
