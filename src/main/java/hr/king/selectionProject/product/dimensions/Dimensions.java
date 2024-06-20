package hr.king.selectionProject.product.dimensions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hr.king.selectionProject.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dimensions")
public class Dimensions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private double width;
    private double height;
    private double depth;

    @OneToOne(mappedBy = "dimensions")
    @JsonBackReference
    private Product product;
}
