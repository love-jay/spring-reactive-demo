package com.jay.reactive.config;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.jay.reactive")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Value("${mongodb.uri}")
    private String url;

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(this.connectionString());
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Bean
    public ConnectionString connectionString() {
        return new ConnectionString(url);
    }


    //    @Override
//    protected Collection<String> getMappingBasePackages() {
//        return Collections.singletonList("com.jay.reactive");
//    }
}
