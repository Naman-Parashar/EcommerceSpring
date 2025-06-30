package com.test.ecommercespring.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreResponseDTO {

    private String status;

    private String message;

    private List<String> categories;
}
