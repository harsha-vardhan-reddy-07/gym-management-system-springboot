package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.EquipmentModel;

public interface EquipmentRepo extends MongoRepository<EquipmentModel, String>{
    
}
