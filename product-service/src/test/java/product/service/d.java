package product.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import product.service.model.Product;
import product.service.repository.ProductRepository;
import product.service.service.ProductServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll_ReturnsListOfProducts() {
        // Arrange
        List<Product> mockProducts = Arrays.asList(
                Product.builder().id(1L).name("Laptop").price(1200.0).build(),
                Product.builder().id(2L).name("Mouse").price(25.0).build()
        );

        when(productRepository.findAll()).thenReturn(mockProducts);

        // Act
        List<Product> result = productService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testSave_ReturnsSavedProduct() {
        // Arrange
        Product productToSave = Product.builder().name("Keyboard").price(50.0).build();
        Product savedProduct = Product.builder().id(10L).name("Keyboard").price(50.0).build();

        when(productRepository.save(productToSave)).thenReturn(savedProduct);

        // Act
        Product result = productService.save(productToSave);

        // Assert
        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("Keyboard", result.getName());
        verify(productRepository, times(1)).save(productToSave);
    }
}

