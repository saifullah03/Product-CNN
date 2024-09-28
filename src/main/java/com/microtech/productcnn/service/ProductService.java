package com.microtech.productcnn.service;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto ProductRequestDto);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);


    //  String getString(int a);
}
