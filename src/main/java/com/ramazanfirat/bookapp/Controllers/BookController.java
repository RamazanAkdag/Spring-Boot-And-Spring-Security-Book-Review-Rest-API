
package com.ramazanfirat.bookapp.Controllers;

import com.ramazanfirat.bookapp.Bussines.IBookService;
import com.ramazanfirat.bookapp.Entities.Entity.BookEntity;
import com.ramazanfirat.bookapp.Entities.Entity.ReviewEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final IBookService bookService;

    

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable String id) {
        return bookService.findById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookEntity book) {
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody BookEntity book) {
        book.setId(id);
        bookService.save(book);
        return ResponseEntity.ok("Book Updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
        return ResponseEntity.ok("Book deleted.");
    }
    
    @PostMapping("/{id}/reviews")
    public ResponseEntity<String> addReviewToBook(@PathVariable String id,@RequestBody ReviewEntity reviewEntity){
        Optional<BookEntity> optionalBook = bookService.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            if (book.getReviews() == null) {
                book.setReviews(new ArrayList<>());
            }
            reviewEntity.setId(UUID.randomUUID().toString());
            book.getReviews().add(reviewEntity);
            bookService.save(book);
            return ResponseEntity.ok("Book review added.");
        } else {
            return (ResponseEntity<String>) ResponseEntity.notFound();
        }
          
    }
    
    @DeleteMapping("/{bookId}/reviews/{reviewId}")
public ResponseEntity<String> deleteReviewFromBook(@PathVariable String bookId, @PathVariable String reviewId) {
    Optional<BookEntity> optionalBook = bookService.findById(bookId);
    if (optionalBook.isPresent()) {
        BookEntity book = optionalBook.get();
        if (book.getReviews() != null) {
            book.setReviews(
                book.getReviews().stream()
                    .filter(review -> !review.getId().equals(reviewId))
                    .collect(Collectors.toList())
            );
            bookService.save(book);
        }
        return ResponseEntity.ok("review deleted");
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
}
