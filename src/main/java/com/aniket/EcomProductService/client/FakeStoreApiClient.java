package com.aniket.EcomProductService.client;

import com.aniket.EcomProductService.dto.FakeStoreRequestDTO;
import com.aniket.EcomProductService.dto.FakeStoreResponseDTO;
import com.aniket.EcomProductService.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreApiClient {
    private final RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIUrl;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct;

    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreAPIUrl) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIUrl=fakeStoreAPIUrl;
    }

    public FakeStoreResponseDTO createProduct(FakeStoreRequestDTO fakeStoreRequestDTO){
        String url = fakeStoreAPIUrl + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO> faeStoreProductResponse= restTemplate.postForEntity(url, fakeStoreRequestDTO, FakeStoreResponseDTO.class);
        return faeStoreProductResponse.getBody();
    }

    public FakeStoreResponseDTO getProductById(int id){
        String getProductByIdUrl = fakeStoreAPIUrl + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreResponseDTO> productResponse= restTemplate.getForEntity(getProductByIdUrl, FakeStoreResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreResponseDTO> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreAPIUrl + fakeStoreAPIPathProduct;
        FakeStoreResponseDTO[] productsArray = restTemplate.getForObject(url, FakeStoreResponseDTO[].class);
        return Arrays.asList(productsArray);
    }

    public boolean deleteProduct(int id){
        String deleteProductUrl = fakeStoreAPIUrl + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductUrl);
        return true;
    }

    public FakeStoreResponseDTO updateProduct(int id, FakeStoreRequestDTO updatedProduct){
        String updateProductUrl = fakeStoreAPIUrl + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.patchForObject(updateProductUrl, updatedProduct, FakeStoreResponseDTO.class);
    }
}
