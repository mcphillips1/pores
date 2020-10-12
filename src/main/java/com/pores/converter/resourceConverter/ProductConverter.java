package com.pores.converter.resourceConverter;

import com.pores.entities.Product;
import com.pores.resource.ProductResource;

public class ProductConverter {


    public static Product convert(ProductResource resource) {
        return Product.builder()
                .beautyGoal(resource.getBeautyGoal())
                .brand(resource.getBrand())
                .formulation(resource.getFormulation())
                .imageLocation(resource.getImageLocation())
                .name(resource.getName())
                .ingredients(resource.getIngredients())
                .pores_price(resource.getPores_price())
                .poresRef(resource.getPoresRef())
                .prices(resource.getPrices())
                .productType(resource.getProductType())
                .rating_pores(resource.getRating_pores())
                .rating_web(resource.getRating_web())
                .skinType(resource.getSkinType())
                .spf(resource.getSpf())
                .volume(resource.getVolume())
                .build();
    }

    public static ProductResource convert(Product product) {
        return ProductResource.builder()
                .beautyGoal(product.getBeautyGoal())
                .brand(product.getBrand())
                .formulation(product.getFormulation())
                .imageLocation(product.getImageLocation())
                .ingredients(product.getIngredients())
                .pores_price(product.getPores_price())
                .poresRef(product.getPoresRef())
                .name(product.getName())
                .productType(product.getProductType())
                .prices(product.getPrices())
                .rating_pores(product.getRating_pores())
                .rating_web(product.getRating_web())
                .skinType(product.getSkinType())
                .spf(product.getSpf())
                .volume(product.getVolume())
                .build();
    }
}
