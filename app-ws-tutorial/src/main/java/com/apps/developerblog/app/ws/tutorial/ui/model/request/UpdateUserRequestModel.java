package com.apps.developerblog.app.ws.tutorial.ui.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserRequestModel {
    @NotNull(message="First name must be provided")
    private String firstName;

    @NotNull(message="Last name must be provided")
    private String lastName;

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
}
