
package com.ramazanfirat.bookapp.Bussines;

import com.ramazanfirat.bookapp.Entities.Entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends UserDetailsService{
    Optional<UserEntity> findById(String id);
    
    

    List<UserEntity> findAll();

    
    void save(UserEntity entity);

    void deleteById(String id);

    void delete(UserEntity entity);
}
