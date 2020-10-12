package com.pores.resource;

import com.pores.entities.Ingredient;
import com.pores.entities.PriceObject;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class ProductResource {

    String poresRef;
    String brand;
    String imageLocation;
    String name;
    List<Ingredient> ingredients;
    String volume;
    List<String> skinType;
    BigDecimal rating_pores;
    BigDecimal rating_web;
    String productType;
    List<String> beautyGoal;
    String formulation;
    String spf;
    BigDecimal pores_price;
    List<PriceObject> prices;


}
