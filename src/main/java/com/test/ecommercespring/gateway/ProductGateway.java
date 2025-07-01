package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.AllProductDTO;

import java.io.IOException;

public interface ProductGateway {


    AllProductDTO getProductById(Long id) throws IOException;
}
