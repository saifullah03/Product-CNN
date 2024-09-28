package com.microtech.productcnn.service;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProductById(Long id);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto);

    void deletProduct(Long id);



}
