package hr.king.selectionProject.product.meta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hr.king.selectionProject.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metas")
@Entity
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String barcode;
    private String qrCode;

    @OneToOne(mappedBy = "meta")
    @JsonBackReference
    private Product product;
}
