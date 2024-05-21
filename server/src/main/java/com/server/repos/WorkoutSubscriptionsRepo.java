package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.WorkoutSubscriptionsModel;

public interface WorkoutSubscriptionsRepo extends MongoRepository<WorkoutSubscriptionsModel, String>{

    WorkoutSubscriptionsModel findByPlanId(String planId);
}
