
package com.ramazanfirat.bookapp.Config;



import com.ramazanfirat.bookapp.Bussines.BookManager;
import com.ramazanfirat.bookapp.Bussines.IBookService;
import com.ramazanfirat.bookapp.Bussines.IUserService;
import com.ramazanfirat.bookapp.Bussines.UserManager;
import com.ramazanfirat.bookapp.Controllers.UserController;
import com.ramazanfirat.bookapp.DataAccess.BookRepository;
import com.ramazanfirat.bookapp.DataAccess.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableMongoRepositories(basePackages = "com.ramazanfirat.bookapp.DataAccess")
public class Config {
 
    @Bean
    public IUserService userService(UserRepository userRepository) {
        return new UserManager(userRepository);
    }
    
    @Bean 
    public IBookService bookService(BookRepository bookRepository){
        return new BookManager(bookRepository);
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(IUserService userService){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        
        return authenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }
    

}
