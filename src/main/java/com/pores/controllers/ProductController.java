package com.pores.controllers;

import com.pores.resource.ProductResource;
import com.pores.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    //addProducts
    @PostMapping("/add-product")
    public ResponseEntity<Void> addProductToDb(@RequestBody ProductResource resource) {
        Long StartTime = System.currentTimeMillis();
        productService.AddNewProducts(resource);
        Long EndTime = System.currentTimeMillis();
        log.info("time taken: {} ms", EndTime - StartTime);
        return ResponseEntity.ok().build();
    }

    //updateProductListing

}
