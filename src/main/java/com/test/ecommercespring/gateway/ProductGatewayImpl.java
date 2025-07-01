package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.AllProductDTO;
import com.test.ecommercespring.dto.FakeStoreResponceProductById;
import com.test.ecommercespring.dto.FakeStoreResponseAllProductListDTO;
import com.test.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProductGatewayImpl implements ProductGateway {

    FakeStoreProductApi fakeStoreProductApi;

    public ProductGatewayImpl(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public AllProductDTO getProductById(Long id) throws IOException {
        FakeStoreResponceProductById fakeStoreResponceProductById = fakeStoreProductApi.getProductById(id).execute().body();
        FakeStoreResponseAllProductListDTO fakeStoreResponseAllProductListDTO = fakeStoreResponceProductById.getProduct();
        AllProductDTO allProductDTO = new AllProductDTO();
        allProductDTO.setId(fakeStoreResponseAllProductListDTO.getId());
        allProductDTO.setTitle(fakeStoreResponseAllProductListDTO.getTitle());
        allProductDTO.setPrice(fakeStoreResponseAllProductListDTO.getPrice());
        allProductDTO.setBrand(fakeStoreResponseAllProductListDTO.getBrand());
        allProductDTO.setModel(fakeStoreResponseAllProductListDTO.getModel());
        allProductDTO.setColor(fakeStoreResponseAllProductListDTO.getColor());
        allProductDTO.setCategory(fakeStoreResponseAllProductListDTO.getCategory());
        allProductDTO.setDiscount(fakeStoreResponseAllProductListDTO.getDiscount());

        return allProductDTO;
    }
}
