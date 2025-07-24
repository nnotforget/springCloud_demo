package com.spring.product.bean;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String productName;
    private BigDecimal price;
    private int num;
}
