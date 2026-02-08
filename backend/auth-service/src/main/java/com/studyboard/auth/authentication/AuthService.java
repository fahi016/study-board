package com.studyboard.auth.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    public void register( RegisterRequest request){
        if (!request.password().equals(request.confirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        //todo register user with email after doing the auth config
    }

    public Long login( LoginRequest request) {
        //todo login user with email after doing the auth config
        return null;
    }
}
