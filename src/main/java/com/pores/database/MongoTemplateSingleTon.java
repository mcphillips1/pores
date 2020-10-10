package com.pores.database;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Objects;

public class MongoTemplateSingleTon extends MongoConfig {

    MongoTemplate template;

    public MongoTemplate getTemplate() {
        if (Objects.isNull(template)) {
            template = new MongoTemplate(mongoClient(), getDatabaseName());
        }
        return template;
    }

}
