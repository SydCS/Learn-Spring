package org.example.domain;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private String name;
    private String text;
}