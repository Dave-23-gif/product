package com.dave.productapi1.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {
     @NotBlank(message = "Name is required")
    private String name;
     @Positive(message = "Price must be greater than 0")
    private BigDecimal price;
     @NotBlank(message = "Description is required")
    private String description;
     @Positive(message = "Quantity must be greater than 0")
    private Integer quantity;
}
