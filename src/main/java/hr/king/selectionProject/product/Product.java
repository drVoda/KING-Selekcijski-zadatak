package hr.king.selectionProject.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hr.king.selectionProject.product.dimensions.Dimensions;
import hr.king.selectionProject.product.meta.Meta;
import hr.king.selectionProject.product.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String description;
    private String category;
    private Double price;
    private Double discountPercentage;
    private Double rating;
    private int stock;

    @ElementCollection
    private List<String> tags;

    private String brand;
    private String sku;
    private Double weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dimensions_id", referencedColumnName = "id")
    @JsonManagedReference
    private Dimensions dimensions;

    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Review> reviews;

    private String returnPolicy;
    private int minimumOrderQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metas_id", referencedColumnName = "id")
    @JsonManagedReference
    private Meta meta;

    @ElementCollection
    private List<String> images;

    private String thumbnail;
}
