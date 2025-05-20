package com.aniket.EcomProductService.service;

import com.aniket.EcomProductService.dto.ProductRequestDTO;
import com.aniket.EcomProductService.dto.ProductResponseDTO;
import com.aniket.EcomProductService.exception.ProductNotFoundException;
import com.aniket.EcomProductService.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
    ProductResponseDTO updateProduct(int id, ProductRequestDTO updatedProduct);
}
