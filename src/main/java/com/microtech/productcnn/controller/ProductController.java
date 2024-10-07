package com.microtech.productcnn.controller;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;
import com.microtech.productcnn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class
ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> addProducts(
            @RequestPart("product") ProductRequestDto productRequestDto,
            @RequestPart("file") MultipartFile file) throws IOException {
        ProductResponseDto productResponseDto = productService.createProduct(productRequestDto,file);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto>getProductById(@PathVariable Long id){
       ProductResponseDto productResponseDto = productService.getProductById(id);
       return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> productResponseDtos = productService.getAllProducts();
        return ResponseEntity.ok(productResponseDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto updateProduct = productService.updateProduct(id,productRequestDto);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletProduct(@PathVariable Long id){
        productService.deletProduct(id);
        return ResponseEntity.noContent().build();
    }



}
