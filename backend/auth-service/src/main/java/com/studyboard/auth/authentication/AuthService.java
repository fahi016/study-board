package com.studyboard.auth.authentication;

import com.studyboard.auth.User.User;
import com.studyboard.auth.User.UserRepository;
import com.studyboard.auth.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void register( RegisterRequest request){
        if (!request.password().equals(request.confirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        if(userRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException("Email already registered");
        }

        var user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        userRepository.save(user);

    }

    public AuthenticationResponse login(LoginRequest request) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.email(),
                       request.password()
               )
       );

       var user = userRepository.findByEmail(request.email())
               .orElseThrow(()->new IllegalArgumentException("Invalid email or password"));

       var jwtToken  = jwtService.generateToken(user);
       return AuthenticationResponse.builder()
               .token(jwtToken )
               .userId(user.getId())
               .email(user.getEmail())
               .build();
    }
}
