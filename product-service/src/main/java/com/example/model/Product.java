package com.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity(name = "PRODUCT_DETAILS")
public class Product {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String category;

    @Basic(optional = false)
    @Column(nullable = false)
    private String brand;

    @Basic(optional = false)
    @Column(nullable = false)
    private String color;

    private Double price;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer size;

    @Basic(optional = false)
    @Column(name = "no_of_product", nullable = false)
    private Integer noOfProduct;

    @Basic(optional = false)
    @Column(nullable = false)
    private String seller;

    @Basic(optional = false)
    @Column(nullable = false)
    private String region;

    private String description;

    @Transient
    private String groupBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return category.equals(product.category) &&
                brand.equals(product.brand) &&
                color.equals(product.color) &&
                seller.equals(product.seller) &&
                region.equals(product.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, brand, color, seller, region);
    }
}
