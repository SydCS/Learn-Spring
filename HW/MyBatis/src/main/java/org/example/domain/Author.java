package org.example.domain;

import lombok.Data;

@Data
public class Author {
    private int id;
    private String username;
    private String password;
    private String email;
    private String bio;
    private String favouriteSection;
}
