package com.microtech.productcnn.service;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto ProductRequestDto);

     //  String getString(int a);
}
