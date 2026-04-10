package com.shreebenakaspace.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.aspectj.bridge.Message;

public class UserDTO {
    private Long id;

    @NotBlank(message = "Name should not be Empty")
    private String name;

    @Email(message = "Invalide Email format")
    @NotBlank(message = "Email should not be empty")
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
