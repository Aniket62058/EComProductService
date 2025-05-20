package com.aniket.EcomProductService.mapper;

import com.aniket.EcomProductService.dto.FakeStoreRequestDTO;
import com.aniket.EcomProductService.dto.FakeStoreResponseDTO;
import com.aniket.EcomProductService.dto.ProductRequestDTO;
import com.aniket.EcomProductService.dto.ProductResponseDTO;

public class ProductMapper {
    public static FakeStoreRequestDTO requestMapper(ProductRequestDTO productRequestDTO){
        FakeStoreRequestDTO fakeStoreRequestDTO = new FakeStoreRequestDTO();
        fakeStoreRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreRequestDTO.setImage(productRequestDTO.getImage());
        fakeStoreRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreRequestDTO.setTitle(productRequestDTO.getTitle());

        return fakeStoreRequestDTO;
    }

    public static ProductResponseDTO responseMapper(FakeStoreResponseDTO fakeStoreResponseDTO){
        ProductResponseDTO  productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreResponseDTO.getId());
        productResponseDTO.setCategory(fakeStoreResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreResponseDTO.getDescription());
        productResponseDTO.setImage(fakeStoreResponseDTO.getImage());
        productResponseDTO.setTitle(fakeStoreResponseDTO.getTitle());
        productResponseDTO.setPrice(fakeStoreResponseDTO.getPrice());

        return productResponseDTO;
    }
}
