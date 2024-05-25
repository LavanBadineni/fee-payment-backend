package com.app.feepayment.beans;

import lombok.Data;

@Data
public class UpdateRequest {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String role;
}
