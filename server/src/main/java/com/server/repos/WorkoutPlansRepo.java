package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.WorkoutPlansModel;

public interface WorkoutPlansRepo extends MongoRepository<WorkoutPlansModel, String>{

    
}
