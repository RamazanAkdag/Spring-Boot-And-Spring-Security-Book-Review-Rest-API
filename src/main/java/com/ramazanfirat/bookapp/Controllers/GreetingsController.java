
package com.ramazanfirat.bookapp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {
    
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
    
    
    
    
  
}
