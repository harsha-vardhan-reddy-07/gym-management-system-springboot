package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.SubscriptionsModel;

public interface SubscriptionsRepo extends MongoRepository<SubscriptionsModel, String>{

    
}
