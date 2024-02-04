
package com.ramazanfirat.bookapp.DataAccess;

import com.ramazanfirat.bookapp.Entities.Entity.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserEntity, String> {
    public UserEntity findByEmail(String email);
}
