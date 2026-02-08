package com.studyboard.auth.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(

    @NotBlank(message = "Customer should be present")
    @Email(message = "Enter valid email format")
    String email,

    @NotBlank(message = "Customer should be present")
    String password,

    @NotBlank(message = "Customer should be present")
    String confirmPassword
) {
}
