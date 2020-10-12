package com.pores.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "Product_Table")
@Builder
@Data
@ToString
public class Product {

    @Transient
    public static final String seqName = "product_sequence";

    @Id
    Long id;

    @TextIndexed
    String brand;

    @TextIndexed(weight = 2.0f)
    String name;

    String imageLocation;
    String poresRef;
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

