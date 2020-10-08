package com.pores.database;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig extends AbstractMongoClientConfiguration {


    private final static String DB_NAME = "pores_product_db";

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }



}
