package com.test.ecommercespring.mapper;

import com.test.ecommercespring.dto.CatagoryDTO;
import com.test.ecommercespring.dto.FakeStoreResponseDTO;

import java.util.List;

public class GetAppCatogeryMapper {

    public static List<CatagoryDTO> toCategoryDTO(FakeStoreResponseDTO fakeStoreResponseDTO) {
        return fakeStoreResponseDTO.getCategories().stream()
                .map((String value) -> CatagoryDTO.builder()
                        .name(value)
                        .build())
                .toList();
    }
}
