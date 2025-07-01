package com.test.ecommercespring.services;

import com.test.ecommercespring.dto.AllProductDTO;
import com.test.ecommercespring.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeStoreProductServiceImpl implements FakeStoreProductService {

    private final ProductGateway ProductGateway;

    public FakeStoreProductServiceImpl(ProductGateway ProductGateway) {
        this.ProductGateway = ProductGateway;
    }

    @Override
    public AllProductDTO getProductById(Long id) throws IOException {
        return this.ProductGateway.getProductById(id);
    }
}
