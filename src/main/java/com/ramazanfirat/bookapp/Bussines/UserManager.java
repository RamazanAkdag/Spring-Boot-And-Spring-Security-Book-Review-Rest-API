
package com.ramazanfirat.bookapp.Bussines;


import com.ramazanfirat.bookapp.DataAccess.UserRepository;
import com.ramazanfirat.bookapp.Entities.Entity.UserEntity;
import java.util.Collections;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserManager implements IUserService {

    private final UserRepository userDal;
  
    
    @Override
    public UserEntity loadUserByUsername(String email){
        return userDal.findByEmail(email);
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return userDal.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDal.findAll();
    }

    @Override
    public void save(UserEntity entity) {
        //default olarak kullanıcı rolu eklendi
        entity.setRoles(Collections.singletonList("ROLE_USER"));
        
        userDal.save(entity);
    }

    @Override
    public void deleteById(String id) {
        userDal.deleteById(id);
    }

    @Override
    public void delete(UserEntity entity) {
        userDal.delete(entity);
    }
}

    

