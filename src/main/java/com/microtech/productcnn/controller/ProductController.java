package com.microtech.productcnn.controller;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;
import com.microtech.productcnn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class
ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> addProducts(@RequestBody ProductRequestDto prdto) {
        ProductResponseDto productResponseDto = productService.createProduct(prdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> productResponseDto = productService.getAllProducts();
        return ResponseEntity.ok(productResponseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){

        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
