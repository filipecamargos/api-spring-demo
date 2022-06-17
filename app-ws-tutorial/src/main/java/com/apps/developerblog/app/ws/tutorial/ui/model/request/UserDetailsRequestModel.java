package com.apps.developerblog.app.ws.tutorial.ui.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message="First name must be provided")
    private String firstName;

    @NotNull(message="Last name must be provided")
    private String lastName;

    @NotNull(message="Email must be provided")
    @Email
    private String email;

    @NotNull(message="Password must be provided")
    @Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters")
    private String password;

    public UserDetailsRequestModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
