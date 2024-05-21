package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.UsersModel;

public interface UsersRepo extends MongoRepository<UsersModel, String>{

    UsersModel findByEmail(String email);
    
}
