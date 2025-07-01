package com.test.ecommercespring.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreResponceProductById {
    private String status;

    private String message;

    private FakeStoreResponseAllProductListDTO product;
}
