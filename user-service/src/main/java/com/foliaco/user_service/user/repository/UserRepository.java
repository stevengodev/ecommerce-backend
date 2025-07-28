package com.foliaco.user_service.user.repository;

import com.foliaco.user_service.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

}
