package com.example.test.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    @Email(message = "Email is not in valid format!")
    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must have at least 3 characters!")
    @Size(max = 20, message = "Name can have at most 20 characters!")
    private String name;
}
