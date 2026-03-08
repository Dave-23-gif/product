package com.dave.productapi1.service;

import com.dave.productapi1.dto.ProductRequestDTO;
import com.dave.productapi1.dto.ProductResponseDTO;
import com.dave.productapi1.entity.Product;
import com.dave.productapi1.mapper.ProductMapper;
import com.dave.productapi1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper  productMapper;
     public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
         Product product= productMapper.toEntity(requestDTO);
         Product savedProduct=productRepository.save(product);

         return  productMapper.toResponseDTO(savedProduct);
     }
     public List<ProductResponseDTO> getAllProducts() {
         return productRepository.findAll()
                 .stream()
                 .map(productMapper::toResponseDTO)
                 .collect(Collectors.toList());
     }
    public ProductResponseDTO getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return productMapper.toResponseDTO(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}



