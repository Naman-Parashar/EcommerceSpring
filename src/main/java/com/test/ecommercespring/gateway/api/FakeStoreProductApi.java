package com.test.ecommercespring.gateway.api;

import com.test.ecommercespring.dto.FakeStoreResponceProductById;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;


public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<FakeStoreResponceProductById> getProductById(@Path("id") Long id) throws IOException;

}
