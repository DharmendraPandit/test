package com.example.service;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;
    private Product product;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        product = create();
    }

    @Test
    public void searchSuccess() {
        List<Product> expectedResult = new ArrayList<>();
        expectedResult.add(product);
        when(repository.findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(product.getCategory(), product.getRegion())).thenReturn(expectedResult);
        List<Product> actualResult = service.search(product);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void searchNoSearchFound() {
        List<Product> expectedResult = new ArrayList<>();
        when(repository.findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(product.getCategory(), product.getRegion())).thenReturn(expectedResult);
        List<Product> actualResult = service.search(product);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void searchWithoutGrouping() {
        List<Product> expectedResult = new ArrayList<>();
        product.setGroupBy(null);
        expectedResult.add(product);
        when(repository.findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(product.getCategory(), product.getRegion())).thenReturn(expectedResult);
        List<Product> actualResult = service.search(product);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void searchWrongInputForGroupBy() {
        List<Product> expectedResult = new ArrayList<>();
        product.setGroupBy("wrongInput");
        expectedResult.add(product);
        when(repository.findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(product.getCategory(), product.getRegion())).thenReturn(expectedResult);
        Assertions.assertThrows(ProductException.class, () -> {
            service.search(product);
        });
    }

    @Test
    public void searchInvalidInput() {
        List<Product> expectedResult = new ArrayList<>();
        product.setCategory(null);
        expectedResult.add(product);
        when(repository.findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(product.getCategory(), product.getRegion())).thenReturn(expectedResult);
        Assertions.assertThrows(ProductException.class, () -> {
            service.search(product);
        });
    }

    private Product create() {
        Product product = new Product();
        product.setId(1L);
        product.setBrand("Nike");
        product.setCategory("Shirts");
        product.setColor("Red");
        product.setGroupBy("brand");
        product.setNoOfProduct(10);
        product.setPrice(100D);
        product.setRegion("Asia");
        product.setSeller("Abc");
        product.setSize(40);
        return product;
    }
}
