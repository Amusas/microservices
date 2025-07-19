package product.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import product.service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
