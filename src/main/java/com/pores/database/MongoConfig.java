package com.pores.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Objects;

@Configuration
@EnableMongoRepositories(basePackages = "com.pores.database.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    MongoTemplate template;

    private final static String DB_NAME = "pores_product_db";

    @Override
    protected String getDatabaseName() {
        return DB_NAME;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        if (Objects.isNull(template)) {
            template = new MongoTemplate(mongoClient(), getDatabaseName());
        }
        return template;
    }


}
