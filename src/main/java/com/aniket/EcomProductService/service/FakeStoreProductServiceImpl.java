package com.aniket.EcomProductService.service;

import com.aniket.EcomProductService.client.FakeStoreApiClient;
import com.aniket.EcomProductService.dto.FakeStoreRequestDTO;
import com.aniket.EcomProductService.dto.FakeStoreResponseDTO;
import com.aniket.EcomProductService.dto.ProductRequestDTO;
import com.aniket.EcomProductService.dto.ProductResponseDTO;
import com.aniket.EcomProductService.exception.ProductNotFoundException;
import com.aniket.EcomProductService.mapper.ProductMapper;
import com.aniket.EcomProductService.model.Product;
import com.aniket.EcomProductService.util.ProductUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.aniket.EcomProductService.mapper.ProductMapper.responseMapper;
import static com.aniket.EcomProductService.util.ProductUtils.isNull;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    private final FakeStoreApiClient fakeStoreApiClient;
    public FakeStoreProductServiceImpl(FakeStoreApiClient fakeStoreApiClient) {
        this.fakeStoreApiClient = fakeStoreApiClient;
    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<FakeStoreResponseDTO> fakeStoreResponseDTOList = fakeStoreApiClient.getAllProducts();
        return fakeStoreResponseDTOList.stream()
                .map(ProductMapper::responseMapper).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreResponseDTO fakeStoreResponseDTO = fakeStoreApiClient.getProductById(id);
        if (isNull(fakeStoreResponseDTO)){
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return responseMapper(fakeStoreResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ProductMapper.requestMapper(productRequestDTO);
        FakeStoreResponseDTO fakeStoreResponseDTO = fakeStoreApiClient.createProduct(fakeStoreRequestDTO);
        return responseMapper(fakeStoreResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        return fakeStoreApiClient.deleteProduct(id);
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO updatedProduct) {
        FakeStoreRequestDTO fakeStoreRequestDTO = ProductMapper.requestMapper(updatedProduct);
        FakeStoreResponseDTO fakeStoreResponseDTO = fakeStoreApiClient.updateProduct(id, fakeStoreRequestDTO);
        return responseMapper(fakeStoreResponseDTO);
    }
}
