
package com.ramazanfirat.bookapp.Entities.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Getter
@Setter
public class ReviewEntity implements IEntity{
    
    @Id
    private String id;
    private String userId;
    private String username;
    private int rating;
    private String comment;
}
