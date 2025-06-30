package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.CatagoryDTO;
import com.test.ecommercespring.dto.FakeStoreResponseDTO;
import com.test.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CategoryGatewayImpl implements CatagoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public CategoryGatewayImpl(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

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
}
