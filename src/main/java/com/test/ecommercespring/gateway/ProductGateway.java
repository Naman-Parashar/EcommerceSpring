package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.AllProductDTO;

import java.io.IOException;
import java.util.List;

public interface ProductGateway {

    List<AllProductDTO> getAllProducts() throws IOException;

    AllProductDTO getProductById(Long id) throws IOException;
}
