package com.test.ecommercespring.configuration;

import com.test.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
@ConfigurationProperties(prefix = "api")
public class RetrofitConfig {

    @Value("${api.base.url}")
    private String baseUrl;

    @Bean
    public Retrofit retrofit() {
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


/**
 * Sol 1
 *
 * @Bean public Retrofit retrofit() {
 * <p>
 * Dotenv dotenv = Dotenv.load();
 * String baseUrl = dotenv.get("FAKESTOREBASEURL");
 * <p>
 * return new Retrofit.Builder()
 * .baseUrl(baseUrl)
 * .addConverterFactory(GsonConverterFactory.create()) // use for serialization and deserialization
 * .build();
 * <p>
 * }
 */