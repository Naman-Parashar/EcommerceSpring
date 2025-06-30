package com.test.ecommercespring.configuration;

import com.test.ecommercespring.gateway.api.FakeStoreCategoryApi;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        Dotenv dotenv = Dotenv.load();
        String baseUrl = dotenv.get("FAKESTOREBASEURL");
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) // use for serialization and deserialization
                .build();
    }

    // this method is now responsible for providing an object of FakeStoreCategoryApi
    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {  // retrofit from the above method
        return retrofit.create(FakeStoreCategoryApi.class);
    }
}
