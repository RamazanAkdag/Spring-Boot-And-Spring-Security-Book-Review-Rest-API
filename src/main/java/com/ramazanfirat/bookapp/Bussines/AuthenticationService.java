
package com.ramazanfirat.bookapp.Bussines;

import com.ramazanfirat.bookapp.Config.JwtService;
import com.ramazanfirat.bookapp.DataAccess.UserRepository;
import com.ramazanfirat.bookapp.Entities.Dtos.AuthenticationRequest;
import com.ramazanfirat.bookapp.Entities.Dtos.AuthenticationResponse;
import com.ramazanfirat.bookapp.Entities.Dtos.RegisterRequest;
import com.ramazanfirat.bookapp.Entities.Entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtService jwtService;
    
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationResponse register(RegisterRequest request){
        List<String> roles = new ArrayList<String>();
        roles.add("ROLE_USER");
        
        var user = UserEntity.builder()
                .email(request.getEmail()).passw(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        
         return AuthenticationResponse.builder().token(jwtToken).build();
    }
    
    
    public AuthenticationResponse authenticate(AuthenticationRequest request ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail());
        
        var jwtToken = jwtService.generateToken(user);
        
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
