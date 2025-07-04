package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.CatagoryDTO;
import com.test.ecommercespring.dto.FakeStoreResponseDTO;
import com.test.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
public class CategoryGatewayImpl implements CatagoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public CategoryGatewayImpl(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CatagoryDTO> getAllCategory() throws IOException {
        // Making the http request to API
        FakeStoreResponseDTO fakeStoreResponseDTO = this.fakeStoreCategoryApi.getFakeStoreCategory().execute().body();
        if (fakeStoreResponseDTO == null) {
            throw new IOException("Failed to fetch fake store category");
        }
        return fakeStoreResponseDTO.getCategories().stream()
                .map((String value) -> CatagoryDTO.builder()
                        .name(value)
                        .build())
                .toList();
        // in the above return statement getCategories ia already provided by retrofit.
    }

    @Override
    public List<CatagoryDTO> getAllCategoryByRestTemplate() {
        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.getForObject("https://fakestoreapi.in/api/products/category", FakeStoreResponseDTO.class);
        return fakeStoreResponseDTO.getCategories().stream()
                .map((String value) -> CatagoryDTO.builder()
                        .name(value)
                        .build())
                .toList();
    }
}
