package com.test;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@SpringBootApplication
class Application {

    @Value("${spring.data.mongodb.database}")
    String dbName;
    @Autowired
    MongoClient mongoClient;
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, dbName);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
