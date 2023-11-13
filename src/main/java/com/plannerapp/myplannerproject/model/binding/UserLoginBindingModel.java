package com.plannerapp.myplannerproject.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3, max = 20, message = "Username length must be at least 3 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password cannot be empty!")
    @Size(min = 3, max = 20, message = "Password length must be at least 3 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
