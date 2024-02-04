
package com.ramazanfirat.bookapp.Entities.Entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Getter
@Setter
@Document(collection = "books")
public class BookEntity implements IEntity{
    
    @Id
    private String id;
    private String title;
    private String author;
    private int publicationYear;
    private List<String> genre;
    private String language;
    private double averageRating;
    private String summary;
    private String imageUrl;
    private List<ReviewEntity> reviews;
    
}
