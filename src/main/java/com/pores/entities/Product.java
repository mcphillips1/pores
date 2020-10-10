package com.pores.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "Product_Table")
public class Product {

    @Transient
    public static final String seqName = "product_sequence";

    @Id
    Long id;
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

    // price is an array containing list of prices associated to sources


    public Product(){

    }

    public Product(Long id, String brand, String imageLocation, String name, BigDecimal pores_price, List<Ingredient> ingredients, String volume, List<String> skinType, BigDecimal rating_pores, BigDecimal rating_web, String productType, List<String> beautyGoal, String formulation, String spf) {
        this.id = id;
        this.brand = brand;
        this.imageLocation = imageLocation;
        this.name = name;
        this.pores_price = pores_price;
        this.ingredients = ingredients;
        this.volume = volume;
        this.skinType = skinType;
        this.rating_pores = rating_pores;
        this.rating_web = rating_web;
        this.productType = productType;
        this.beautyGoal = beautyGoal;
        this.formulation = formulation;
        this.spf = spf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPores_price() {
        return pores_price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getVolume() {
        return volume;
    }

    public List<String> getSkinType() {
        return skinType;
    }

    public BigDecimal getRating_pores() {
        return rating_pores;
    }

    public BigDecimal getRating_web() {
        return rating_web;
    }

    public String getProductType() {
        return productType;
    }

    public List<String> getBeautyGoal() {
        return beautyGoal;
    }

    public String getFormulation() {
        return formulation;
    }

    public String getSpf() {
        return spf;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                ", name='" + name + '\'' +
                ", price=" + pores_price +
                ", ingredients=" + ingredients +
                ", volume='" + volume + '\'' +
                ", skinType=" + skinType +
                ", rating_pores=" + rating_pores +
                ", rating_web=" + rating_web +
                ", productType='" + productType + '\'' +
                ", beautyConcern=" + beautyGoal +
                ", formulation='" + formulation + '\'' +
                ", spf='" + spf + '\'' +
                '}';
    }
}

