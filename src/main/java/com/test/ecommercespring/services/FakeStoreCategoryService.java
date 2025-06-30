package com.test.ecommercespring.services;

import com.test.ecommercespring.dto.CatagoryDTO;

import java.io.IOException;
import java.util.List;

public interface FakeStoreCategoryService {
    List<CatagoryDTO> getAllCategory() throws IOException;
}
