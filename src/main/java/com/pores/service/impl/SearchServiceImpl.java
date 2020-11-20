package com.pores.service.impl;

import com.pores.converter.resourceConverter.ProductConverter;
import com.pores.database.repository.ProductRepo;
import com.pores.database.repository.UserRepo;
import com.pores.entities.PoresUser;
import com.pores.entities.Product;
import com.pores.resource.ProductResource;
import com.pores.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.TextCriteria.forDefaultLanguage;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final UserRepo userRepo;
    private final MongoTemplate template;
    private final ProductRepo productRepo;


    @Override
    public List<ProductResource> getSuggestions(String ref) {
        final String beautyGoal = "beautyGoal";
        PoresUser poresUser = userRepo.findByRef(ref);

        String skinType = poresUser.getProfile().getSkinType();
        List<Product> suggestedProducts = template
                .query(Product.class)
                .matching(query(where(beautyGoal).elemMatch(where(beautyGoal).in(skinType))))
                .all();

        return suggestedProducts.stream().map(ProductConverter::convert).collect(Collectors.toList());
    }

    @Override
    public List<ProductResource> getResults(String searchTerm) {
        Query query = TextQuery.queryText(
                forDefaultLanguage()
                        .caseSensitive(false)
                        .matchingAny(searchTerm.split(" ")));
        List<Product> searchedProducts = template.find(query,Product.class);
        return searchedProducts.stream().map(ProductConverter::convert).collect(Collectors.toList());
    }
}
