
package com.ramazanfirat.bookapp.Bussines;

import com.ramazanfirat.bookapp.Entities.Entity.BookEntity;
import java.util.List;
import java.util.Optional;

public interface IBookService {
    Optional<BookEntity> findById(String id);
    
    

    List<BookEntity> findAll();

    
    void save(BookEntity entity);

    void deleteById(String id);

    void delete(BookEntity entity);
    
    
}
