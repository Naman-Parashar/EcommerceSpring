package com.test.ecommercespring.configuration;

import com.test.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/") // idealy this url should come from environment variable
                .addConverterFactory(GsonConverterFactory.create()) // use for serialization and deserialization
                .build();
    }

    // this method is now responsible for providing an object of FakeStoreCategoryApi
    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {  // retrofit from the above method
        return retrofit.create(FakeStoreCategoryApi.class);
    }
}
