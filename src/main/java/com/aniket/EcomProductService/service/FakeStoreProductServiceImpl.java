package com.aniket.EcomProductService.service;

import com.aniket.EcomProductService.dto.ProductResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductServiceImpl implements ProductService{
    private final RestTemplate restTemplate;
    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        String url="https://fakestoreapi.com/products";
        ProductResponseDTO[] productsArray = restTemplate.getForObject(url, ProductResponseDTO[].class);
        return Arrays.asList(productsArray);
    }
}
