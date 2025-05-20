package com.aniket.EcomProductService.controller;

import com.aniket.EcomProductService.dto.ProductRequestDTO;
import com.aniket.EcomProductService.dto.ProductResponseDTO;
import com.aniket.EcomProductService.exception.ProductNotFoundException;
import com.aniket.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    /**
     * Field Injection : Not Recommended
     * @Autowired
     * private ProductService productService;
     */

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity getAllProduct(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity updateProductById(@PathVariable("id") int id, @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }
}
