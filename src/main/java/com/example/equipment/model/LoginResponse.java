package com.example.equipment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {
    @JsonProperty
    private String authToken;

    @JsonCreator
    public LoginResponse(@JsonProperty("authToken") String authToken) {
        this.authToken = authToken;
    }


}
