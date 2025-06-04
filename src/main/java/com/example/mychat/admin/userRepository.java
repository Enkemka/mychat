package com.example.mychat.admin;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<user, String> {

    user findByUsername(String userName);
}
