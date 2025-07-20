package com.spring.order.order.bean;

import com.spring.order.product.bean.Product;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;

}
