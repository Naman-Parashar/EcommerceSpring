package com.test.ecommercespring.gateway.api;

import com.test.ecommercespring.dto.FakeStoreResponseAllProductDTO;
import com.test.ecommercespring.dto.FakeStoreResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreCategoryApi {

    // complete url is this:"https://fakestoreapi.in/api/products/category"
    @GET("products/category")
    Call<FakeStoreResponseDTO> getFakeStoreCategory();

    // complete url is this:"https://fakestoreapi.in/api/products"
    @GET("products")
    Call<FakeStoreResponseAllProductDTO> getAllProducts();
}
