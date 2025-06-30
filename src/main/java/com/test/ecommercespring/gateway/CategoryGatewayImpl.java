package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.*;
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

    public List<AllProductDTO> getAllProducts() throws IOException {
        FakeStoreResponseAllProductDTO fakeStoreResponseAllProductDTO = this.fakeStoreCategoryApi.getAllProducts().execute().body();

        if (fakeStoreResponseAllProductDTO == null) {
            throw new IOException("Failed to fetch fake store category");
        }
        List<FakeStoreResponseAllProductListDTO> listOfProduct = fakeStoreResponseAllProductDTO.getProducts();
        System.out.println(fakeStoreResponseAllProductDTO);
        return listOfProduct.stream()
                .map((FakeStoreResponseAllProductListDTO product) -> {
                    AllProductDTO dto = new AllProductDTO();
                    dto.setId(product.getId());
                    dto.setTitle(product.getTitle());
                    dto.setPrice(product.getPrice());
                    dto.setBrand(product.getBrand());
                    dto.setModel(product.getModel());
                    dto.setColor(product.getColor());
                    dto.setCategory(product.getCategory());
                    dto.setDiscount(product.getDiscount());
                    return dto;
                }).toList();
    }
}
