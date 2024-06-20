package hr.king.selectionProject.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSummary {
    private String thumbnail;
    private String title;
    private Double price;
    private String description;
}
