package com.pores.entities;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    Long id;
    String brand;
    String imageLocation;
    String name;
    BigDecimal price;
    List<Ingredient> ingredients;
    String volume;
    List<String> skinType;
    BigDecimal rating_pores;
    BigDecimal rating_web;
    String productType;
    List<String> beautyConcern;
    String formulation;
    String spf;

    public Product(Long id, String brand, String imageLocation, String name, BigDecimal price, List<Ingredient> ingredients, String volume, List<String> skinType, BigDecimal rating_pores, BigDecimal rating_web, String productType, List<String> beautyConcern, String formulation, String spf) {
        this.id = id;
        this.brand = brand;
        this.imageLocation = imageLocation;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.volume = volume;
        this.skinType = skinType;
        this.rating_pores = rating_pores;
        this.rating_web = rating_web;
        this.productType = productType;
        this.beautyConcern = beautyConcern;
        this.formulation = formulation;
        this.spf = spf;
    }

    public Long getId() {
        return id;
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

    public BigDecimal getPrice() {
        return price;
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

    public List<String> getBeautyConcern() {
        return beautyConcern;
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
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", volume='" + volume + '\'' +
                ", skinType=" + skinType +
                ", rating_pores=" + rating_pores +
                ", rating_web=" + rating_web +
                ", productType='" + productType + '\'' +
                ", beautyConcern=" + beautyConcern +
                ", formulation='" + formulation + '\'' +
                ", spf='" + spf + '\'' +
                '}';
    }
}

