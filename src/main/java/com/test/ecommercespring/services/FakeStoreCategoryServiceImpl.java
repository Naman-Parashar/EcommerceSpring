package com.test.ecommercespring.services;

import com.test.ecommercespring.dto.CatagoryDTO;
import com.test.ecommercespring.gateway.CatagoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements FakeStoreCategoryService {

    private final CatagoryGateway catagoryGateway;

    public FakeStoreCategoryServiceImpl(CatagoryGateway catagoryGateway) {
        this.catagoryGateway = catagoryGateway;
    }

    @Override
    public List<CatagoryDTO> getAllCategory() throws IOException {
        return this.catagoryGateway.getAllCategory();
    }

    @Override
    public List<CatagoryDTO> getAllCategoryByRestTemplate() {
        return this.catagoryGateway.getAllCategoryByRestTemplate();
    }
}
