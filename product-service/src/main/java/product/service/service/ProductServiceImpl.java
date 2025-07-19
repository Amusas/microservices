package product.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import product.service.model.Product;
import product.service.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        log.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        log.debug("Found {} products", products.size());
        return products;
    }

    @Override
    public Product save(Product product) {
        log.info("Saving new product: {}", product.getName());
        Product saved = productRepository.save(product);
        log.debug("Saved product with ID: {}", saved.getId());
        return saved;
    }
}
