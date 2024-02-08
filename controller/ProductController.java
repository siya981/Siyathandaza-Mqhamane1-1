package com.enviro.assessment.grad001.siyathandazamqhamane.controller;


import com.enviro.assessment.grad001.siyathandazamqhamane.model.*;
import com.enviro.assessment.grad001.siyathandazamqhamane.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product_creation")
    ProductCreationResponse creatProduct( @Valid  @RequestBody ProductCreationRequest productCreationRequest) {
        return productService.productCreation(productCreationRequest);
    }


}


