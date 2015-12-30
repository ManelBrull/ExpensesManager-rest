package com.mbrull.core.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 25, message = "Username length should be between 3 and 25")
    @Pattern(regexp = "(\\w|\\d)*", message = "Username should only have words and digits")
    private String username;
    @NotNull(message = "Email cannot be null")
    @Size(max = 250, message = "Email too long, max length allowed is 250")
    private String email;
    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "(\\S)*", message = "Password should not have whitespaces")
    @Size(min = 8, max = 250, message = "Password length should be between 8 and 250")
    private String password;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
