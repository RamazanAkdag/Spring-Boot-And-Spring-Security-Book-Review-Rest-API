
package com.ramazanfirat.bookapp.Entities.Dtos;

import com.ramazanfirat.bookapp.Entities.Dtos.IDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements IDto{
    private String username;
    private String password;
    private String email;
    
    
    
}
