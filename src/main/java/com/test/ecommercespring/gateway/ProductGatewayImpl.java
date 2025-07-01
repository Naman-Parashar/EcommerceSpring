package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.AllProductDTO;
import com.test.ecommercespring.dto.FakeStoreResponceProductById;
import com.test.ecommercespring.dto.FakeStoreResponseAllProductDTO;
import com.test.ecommercespring.dto.FakeStoreResponseAllProductListDTO;
import com.test.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ProductGatewayImpl implements ProductGateway {

    FakeStoreProductApi fakeStoreProductApi;

    public ProductGatewayImpl(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    public List<AllProductDTO> getAllProducts() throws IOException {
        FakeStoreResponseAllProductDTO fakeStoreResponseAllProductDTO = this.fakeStoreProductApi.getAllProducts().execute().body();

        if (fakeStoreResponseAllProductDTO == null) {
            throw new IOException("Failed to fetch fake store category");
        }
        List<FakeStoreResponseAllProductListDTO> listOfProduct = fakeStoreResponseAllProductDTO.getProducts();

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
