package com.test.ecommercespring.gateway.api;

import com.test.ecommercespring.dto.FakeStoreResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

// com,plete url is this :"https://fakestoreapi.in/api/products/category"

public interface FakeStoreCategoryApi {
    @GET("products/category")
    Call<FakeStoreResponseDTO> getFakeStoreCategory();
}
