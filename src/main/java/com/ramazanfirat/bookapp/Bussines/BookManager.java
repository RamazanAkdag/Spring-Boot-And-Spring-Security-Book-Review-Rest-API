
package com.ramazanfirat.bookapp.Bussines;

import com.ramazanfirat.bookapp.DataAccess.BookRepository;
import com.ramazanfirat.bookapp.Entities.Entity.BookEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookManager implements IBookService{
    
    private final BookRepository bookDal;

    @Override
    public Optional<BookEntity> findById(String id) {
       return bookDal.findById(id);
    }

    @Override
    public List<BookEntity> findAll() {
       return bookDal.findAll();
    }

    @Override
    public void save(BookEntity entity) {
       bookDal.save(entity);
    }

    @Override
    public void deleteById(String id) {
       bookDal.deleteById(id);
    }

    @Override
    public void delete(BookEntity entity) {
       bookDal.delete(entity);
    }
    
}
