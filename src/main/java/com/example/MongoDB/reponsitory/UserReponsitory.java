package com.example.MongoDB.reponsitory;

import com.example.MongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends MongoRepository<User, Integer> {
    User findByUsername(String userName);
}
