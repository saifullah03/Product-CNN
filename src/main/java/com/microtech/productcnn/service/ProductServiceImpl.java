package com.microtech.productcnn.service;

import com.microtech.productcnn.dto.ProductRequestDto;
import com.microtech.productcnn.dto.ProductResponseDto;
import com.microtech.productcnn.entity.Product;
import com.microtech.productcnn.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${image.upload.dir}")
    private String uploadDir;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto, MultipartFile file) throws IOException {

        Product product = modelMapper.map(productRequestDto, Product.class);

        if(file != null && !file.isEmpty()){
          String fileName = saveImage(file,product);
          product.setImage(fileName);
        }

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

        return modelMapper.map(updatedProduct, ProductResponseDto.class);
    }

    @Override
    public void deletProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);
    }

    private String saveImage(MultipartFile file, Product product) throws IOException {
        Path uploadPath = Paths.get(uploadDir + "/product");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileName = product.getName() + "_" + UUID.randomUUID().toString();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);
        return fileName;
    }


}
