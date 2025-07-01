package com.test.ecommercespring.controllers;

import com.test.ecommercespring.dto.CatagoryDTO;
import com.test.ecommercespring.services.FakeStoreCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/fakestore")
public class CategoryController {

    private final FakeStoreCategoryService fakeStoreCategoryService;

    // DI using constructor
    CategoryController(FakeStoreCategoryService fakeStoreCategoryService) {
        this.fakeStoreCategoryService = fakeStoreCategoryService;
    }

    @GetMapping
    public String getApi() {
        return "Welcome to EcommerceSpring Fake Store";
    }

    @GetMapping("getallcategory")
    public ResponseEntity<List<CatagoryDTO>> getAllCategory() throws IOException {
        List<CatagoryDTO> result = fakeStoreCategoryService.getAllCategory();
        return ResponseEntity.ok(result);
    }

}


/*  Example
 // if after category {above url} there is nothing
 @GetMapping public String getDetails() {
 return "This is the category API Get Request";
 }

 // if after category {above url} there is getcategoryname
 @GetMapping("/getcategoryname") public String getCategoryName() {
 return "electronics";
 }

 // if after category {above url} there is a count
 @GetMapping("/count") public int getCount() {
 return 5;
 }

 @PostMapping public String postCategory() {
 return "This is the category API as a post request";
 }
 */

/* using annotadion for DI


 @Autowired private FakeStoreCategoryService fakeStoreCategoryService;

 @GetMapping public List<String> getAllCategory(){
 return fakeStoreCategoryService.getAllCategory();
 }


 */