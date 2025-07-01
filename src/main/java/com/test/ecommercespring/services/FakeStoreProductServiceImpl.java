package com.test.ecommercespring.services;

import com.test.ecommercespring.dto.AllProductDTO;
import com.test.ecommercespring.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements FakeStoreProductService {

    private final ProductGateway productGateway;

    public FakeStoreProductServiceImpl(ProductGateway ProductGateway) {
        this.productGateway = ProductGateway;
    }

    @Override
    public List<AllProductDTO> getAllProducts() throws IOException {
        return this.productGateway.getAllProducts();
    }

    @Override
    public AllProductDTO getProductById(Long id) throws IOException {
        return this.productGateway.getProductById(id);
    }
}
