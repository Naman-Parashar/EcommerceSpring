package com.test.ecommercespring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreResponseAllProductDTO {

    private String status;

    private String message;

    private List<FakeStoreResponseAllProductListDTO> products;
}
