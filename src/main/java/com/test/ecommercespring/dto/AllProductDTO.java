package com.test.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductDTO {

    private Integer id;

    private String title;

    private Integer price;

    private String brand;

    private String model;

    private String color;

    private String category;

    private Integer discount;
}
