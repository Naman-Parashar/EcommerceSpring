package com.test.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreResponseAllProductListDTO {

    private Integer id;

    private String title;

    private String image;

    private Integer price;

    private String description;

    private String brand;

    private String model;

    private String color;

    private String category;

    private Integer discount;
}
