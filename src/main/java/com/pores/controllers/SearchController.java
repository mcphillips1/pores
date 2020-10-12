package com.pores.controllers;

import com.pores.resource.ProductResource;
import com.pores.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/suggestions")
    public ResponseEntity<List<ProductResource>> getSearchSuggestions(@RequestParam String ref) {
        List<ProductResource> productResources = searchService.getSuggestions(ref);
        return ResponseEntity.ok(productResources);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResource>> getBySearchTerms(@RequestParam String searchTerm){
        return ResponseEntity.ok(searchService.getResults(searchTerm));
    }




}
