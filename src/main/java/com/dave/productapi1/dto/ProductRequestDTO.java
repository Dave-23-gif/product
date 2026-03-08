package com.dave.productapi1.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {

    private String name;

    private BigDecimal price;
    private String description;
    private Integer quantity;
}
