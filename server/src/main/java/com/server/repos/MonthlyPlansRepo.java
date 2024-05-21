package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.MonthlyPlansModel;

public interface MonthlyPlansRepo extends MongoRepository<MonthlyPlansModel, String>{

    
}
