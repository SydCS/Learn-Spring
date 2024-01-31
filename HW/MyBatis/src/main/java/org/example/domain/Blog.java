package org.example.domain;

import lombok.Data;

import java.util.List;

import org.example.utils.State;

@Data
public class Blog {
    private int id;
    private String title;

    private Author author;
    private List<Post> posts;

    private State state;
}