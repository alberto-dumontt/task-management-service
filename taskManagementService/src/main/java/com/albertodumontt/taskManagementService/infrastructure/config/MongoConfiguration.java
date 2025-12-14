package com.albertodumontt.taskManagementService.infrastructure.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.lang.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoConfiguration extends AbstractMongoClientConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfiguration.class);

    @Value("${database.cluster}")
    private String cluster;

    @Value("${database.dbname}")
    private String database;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${mongo.db.test.url}")
    private String testDbConnectionString;

    @Value("${mongo.db.test.enabled}")
    private boolean isTestEnabled;

    @Override
    public @NonNull MongoClient mongoClient() {
        if (isTestEnabled) {
            LOGGER.info("Connecting to Mongo DB: {}", testDbConnectionString);
            return MongoClients.create(testDbConnectionString);
        } else {
            LOGGER.info("Connecting to Mongo DB: {}", getConnectionString(true));
            final ConnectionString connectionString = new ConnectionString(getConnectionString(false));
            final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            return MongoClients.create(mongoClientSettings);
        }
    }

    protected String getConnectionString(boolean isLogsEnabled) {
        StringBuilder mongoConnectionString = new StringBuilder();
        mongoConnectionString.append("mongodb+srv://").append(username).append(":");
        if (isLogsEnabled) {
            mongoConnectionString.append("[*******]");
        } else {
            mongoConnectionString.append(password);
        }
        mongoConnectionString.append("@").append(cluster).append("/");
        mongoConnectionString.append(database).append("?retryWrites=true&w=majority");
        return mongoConnectionString.toString();
    }

    @Override
    protected @NonNull String getDatabaseName() {
        return database;
    }
}