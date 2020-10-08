package com.pores.converter.resourceConverter;

import com.pores.entities.Product;
import com.pores.resource.ProductResource;

public class ProductConverter {

    public static Product convert(ProductResource resource){
        return new Product();
    }

    public static ProductResource convert(Product product){
        return null;
    }
}
