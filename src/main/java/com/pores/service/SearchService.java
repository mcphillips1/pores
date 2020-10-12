package com.pores.service;

import com.pores.resource.ProductResource;

import java.util.List;

public interface SearchService {

    List<ProductResource> getSuggestions(String ref);

    List<ProductResource> getResults(String searchTerm);
}
