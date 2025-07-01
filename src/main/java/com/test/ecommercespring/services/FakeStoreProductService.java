package com.test.ecommercespring.services;

import com.test.ecommercespring.dto.AllProductDTO;

import java.io.IOException;

public interface FakeStoreProductService {


    AllProductDTO getProductById(Long id) throws IOException;
}
