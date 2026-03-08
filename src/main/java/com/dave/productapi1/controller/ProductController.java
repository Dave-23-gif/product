package com.dave.productapi1.controller;

import com.dave.productapi1.dto.ProductRequestDTO;
import com.dave.productapi1.dto.ProductResponseDTO;
import com.dave.productapi1.entity.Product;
import com.dave.productapi1.service.ProductService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Resource
@RequestMapping("api1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@RequestParam long id) {
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@RequestParam long id) {
        productService.deleteProduct(id);
    }
}
