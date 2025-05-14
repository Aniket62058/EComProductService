package com.aniket.EcomProductService.service;

import com.aniket.EcomProductService.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
}
