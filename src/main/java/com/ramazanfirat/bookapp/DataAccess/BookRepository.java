
package com.ramazanfirat.bookapp.DataAccess;

import com.ramazanfirat.bookapp.Entities.Entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<BookEntity, String>{
    
}
