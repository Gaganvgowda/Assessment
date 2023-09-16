package com.employee.employee.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @JsonProperty("first_name")
    String first_name;

    @JsonProperty("last_name")
    String last_name;

    @JsonProperty("email")
    String email;


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
