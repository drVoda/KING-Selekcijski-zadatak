package hr.king.selectionProject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p where p.category LIKE (case when :categorySlug = 'any' then '%' else :categorySlug end) and p.price > :priceGt and (case when :priceLt = -1 then TRUE else p.price < :priceLt end) ")
    List<Product> findByPriceAndCategory(@Param("categorySlug") String categorySlug, @Param("priceGt") double priceGt, @Param("priceLt") double priceLt);

    @Query(value = "SELECT p FROM Product p WHERE lower(p.title) LIKE '%' || lower(:name) || '%'")
    List<Product> findByNameContainingIgnoreCase(@Param("name") String name);
}
