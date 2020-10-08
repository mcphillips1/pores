package com.pores.service;

import com.pores.resource.ProductResource;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

public interface ProductService {

    void AddNewProducts(ProductResource resource);

    void UpdateProduct(ProductResource resource);

    List<ProductResource> getAllProducts();

    List<ProductResource> getAllProductByKeyword(String searchTerm);


}
