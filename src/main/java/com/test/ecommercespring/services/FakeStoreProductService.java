package com.test.ecommercespring.services;

import com.test.ecommercespring.dto.AllProductDTO;

import java.io.IOException;
import java.util.List;

public interface FakeStoreProductService {

    List<AllProductDTO> getAllProducts() throws IOException;

    AllProductDTO getProductById(Long id) throws IOException;
}
