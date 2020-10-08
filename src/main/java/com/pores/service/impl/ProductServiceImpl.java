package com.pores.service.impl;

import com.pores.database.IDGenerator;
import com.pores.database.repository.ProductRepo;
import com.pores.entities.Product;
import com.pores.resource.ProductResource;
import com.pores.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.pores.converter.resourceConverter.ProductConverter.convert;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final IDGenerator idGenerator;
    private final ProductRepo productRepo;
    private final MongoOperations operations;


    @Override
    public void AddNewProducts(ProductResource resource) {
        long startTime = System.currentTimeMillis();
        Product product = convert(resource);
        product.setId(idGenerator.generateSequence(Product.seqName));
        productRepo.save(product);
        long endtime = System.currentTimeMillis();
        log.info("Adding to database: {}, Time taken {}", product.getId(), endtime - startTime);
    }

    @Override
    public void UpdateProduct(ProductResource resource) {
        //method to be used to update beautyGoal.
    }

    @Override
    public List<ProductResource> getAllProducts() {
        long startTime = System.currentTimeMillis();
        List<ProductResource> apiList = new ArrayList<>();
        List<Product> results = productRepo.findAll();
        results.forEach(r -> {
            apiList.add(convert(r));
        });
        long endtime = System.currentTimeMillis();

        return apiList;
    }

    @Override
    public List<ProductResource> getAllProductByKeyword(String searchTerm) {
        //May need to switch to mongotemplate for speed.


//        Set<ProductResource> resources = new HashSet<>();
//
//            Query query = TextQuery.query(new TextCriteria().matchingAny());
//
//            List<Document> page = productRepo.find(query, Product.class);
//

        return null;
    }
}
