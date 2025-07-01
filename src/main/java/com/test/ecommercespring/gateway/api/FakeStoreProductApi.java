package com.test.ecommercespring.gateway.api;

import com.test.ecommercespring.dto.FakeStoreResponceProductById;
import com.test.ecommercespring.dto.FakeStoreResponseAllProductDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;


public interface FakeStoreProductApi {

    // complete url is this:"https://fakestoreapi.in/api/products"
    @GET("products")
    Call<FakeStoreResponseAllProductDTO> getAllProducts();

    @GET("products/{id}")
    Call<FakeStoreResponceProductById> getProductById(@Path("id") Long id) throws IOException;

}
