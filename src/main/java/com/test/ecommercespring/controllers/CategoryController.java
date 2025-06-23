package com.test.ecommercespring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    // if after category {above url} there is nothing
    @GetMapping
    public String getDetails() {
        return "This is the category API";
    }

    // if after category {above url} there is getcategoryname
    @GetMapping("/getcategoryname")
    public String getCategoryName() {
        return "electronics";
    }

    // if after category {above url} there is count
    @GetMapping("/count")
    public int getCount() {
        return 5;
    }

    @PostMapping
    public String postCategory() {
        return "This is the category API as a post request";
    }

}
