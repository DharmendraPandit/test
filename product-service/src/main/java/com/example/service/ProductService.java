package com.example.service;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.utility.ProductMessages;
import com.example.utility.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class ProductService {

    final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository repository;

    public List<Product> search(Product product) {
        Validation.validateCategory(product.getCategory(), product.getRegion());

        List<Product> searchResult = repository.findByCategoryIgnoreCaseContainingAndRegionIgnoreCase(product.getCategory(), product.getRegion());
        if(searchResult.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        if(!StringUtils.isEmpty(product.getGroupBy())) {
            Validation.validateGroupBy(product.getGroupBy());
            searchResult = grouping(searchResult, product.getGroupBy());
        }

        return searchResult;
    }

    private List<Product> grouping(List<Product> productList, String groupBy) {
        ConcurrentMap<Object, List<Product>> groupedProductMap = null;
        ProductMessages grouping = Enum.valueOf(ProductMessages.class, groupBy);
        switch (grouping) {
            case brand:
                groupedProductMap = productList.parallelStream().collect(Collectors.groupingByConcurrent(Product::getBrand));
                break;
            case price:
                groupedProductMap = productList.parallelStream().collect(Collectors.groupingByConcurrent(Product::getPrice));
                break;
            case color:
                groupedProductMap = productList.parallelStream().collect(Collectors.groupingByConcurrent(Product::getColor));
                break;
            case size:
                groupedProductMap = productList.parallelStream().collect(Collectors.groupingByConcurrent(Product::getSize));
                break;
            default:
                log.info("groupBy is invalid");
                throw new ProductException(HttpStatus.BAD_REQUEST.value(), ProductMessages.GROUPBY_INVALID.getMessage());
        }

        List<Product> newList = new ArrayList<>();
        if(null != groupedProductMap && !groupedProductMap.isEmpty()) {
            groupedProductMap.forEach( (k, v) -> {
                newList.addAll(v);
            });
        }

        return newList;
    }

}
