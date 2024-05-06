package com.scaler.firstjavaproject.firstjavaproject.Service;

import com.scaler.firstjavaproject.firstjavaproject.DTO.FakeStoreResponseDTO;
import com.scaler.firstjavaproject.firstjavaproject.Model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(int id) {
        ResponseEntity<FakeStoreResponseDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreResponseDTO.class);
        FakeStoreResponseDTO fakeStoreResponseDTO = response.getBody();
        assert fakeStoreResponseDTO != null;
        return fakeStoreResponseDTO.convertToProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, String image, String category) {
        FakeStoreResponseDTO requestBody = new FakeStoreResponseDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setImage(image);
        requestBody.setPrice(String.valueOf(price));
        requestBody.setCategory(category);

        FakeStoreResponseDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",
                requestBody, FakeStoreResponseDTO.class);
        return response.convertToProduct();

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> prod = new ArrayList<>();
        FakeStoreResponseDTO[] resp = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);
        for(FakeStoreResponseDTO dto : resp) {
            prod.add(dto.convertToProduct());
        }
        return prod;
    }

}
