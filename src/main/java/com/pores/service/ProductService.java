package com.pores.service;

import com.pores.resource.ProductResource;

import java.util.List;

public interface ProductService {

    void AddNewProducts(ProductResource resource);

    void UpdateProduct(ProductResource resource);

    List<ProductResource> getAllProducts();

    List<ProductResource> getAllProductByKeyword(String searchTerm);


}
