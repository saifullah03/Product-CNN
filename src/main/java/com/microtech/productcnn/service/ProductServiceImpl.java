package com.microtech.productcnn.service;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;
import com.microtech.productcnn.entity.Product;
import com.microtech.productcnn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto prqdto) {

      if(prqdto.getEntryDate()==null || prqdto.getEntryDate().isEmpty()){
          String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          prqdto.setEntryDate(currentDate);
      }
        Product product = convertToEntity(prqdto);
        Product savedProduct = productRepository.save(product);
        ProductResponseDto responseDto = convertToReponseDto(savedProduct);
        return responseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product: products){
            ProductResponseDto productResponseDto = convertToReponseDto(product);
            productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }


    private Product convertToEntity(ProductRequestDto prodRqDto) {
        Product product = new Product();
        product.setName(prodRqDto.getName());
        product.setPrice(prodRqDto.getPrice());
        product.setDescription(prodRqDto.getDescription());
        product.setEntryDate(prodRqDto.getEntryDate());
        return product;
    }

    private ProductResponseDto convertToReponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setDescription(product.getDescription());
        return productResponseDto;
    }
}
