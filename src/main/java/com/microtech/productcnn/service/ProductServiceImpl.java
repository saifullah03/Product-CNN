package com.microtech.productcnn.service;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;
import com.microtech.productcnn.entity.Product;
import com.microtech.productcnn.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {

        Product product = modelMapper.map(productRequestDto, Product.class);
        Product savedProduct = productRepository.save(product);


        ProductResponseDto responseDto = modelMapper.map(savedProduct, ProductResponseDto.class);
        return responseDto;
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .toList();

    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        modelMapper.map(productRequestDto, existingProduct);

        Product updatedProduct = productRepository.save(existingProduct);

        return modelMapper.map(updatedProduct,ProductResponseDto.class);
    }

    @Override
    public void deletProduct(Long id) {
      Product product =  productRepository.findById(id).orElse(null);
      productRepository.delete(product);
    }


}
