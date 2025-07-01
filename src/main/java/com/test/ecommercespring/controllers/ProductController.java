package com.test.ecommercespring.controllers;

import com.test.ecommercespring.dto.AllProductDTO;
import com.test.ecommercespring.services.FakeStoreProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/fakestore/product")
public class ProductController {

    private final FakeStoreProductService fakeStoreProductService;

    ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping
    public String getProductApi() {
        return "Welcome to EcommerceSpring Fake Store wanna search product";
    }

    @GetMapping("getallproducts")
    public ResponseEntity<List<AllProductDTO>> getAllProducts() throws IOException {
        return ResponseEntity.ok(fakeStoreProductService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllProductDTO> getProductById(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(this.fakeStoreProductService.getProductById(id));
    }
}
