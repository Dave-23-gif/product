package com.dave.productapi1.controller;

import com.dave.productapi1.dto.ProductRequestDTO;
import com.dave.productapi1.dto.ProductResponseDTO;
import com.dave.productapi1.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
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
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(
            @PathVariable Long id,
           @Valid @RequestBody ProductRequestDTO dto) {

        return productService.updateProduct(id, dto);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@RequestParam long id) {
        productService.deleteProduct(id);
    }
}
