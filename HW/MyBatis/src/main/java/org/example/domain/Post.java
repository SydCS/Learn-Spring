package org.example.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Post {
    private int id;
    private LocalDateTime createdOn;
    private String section;
    private String subject;
    private Boolean draft;
    private String body;

    private List<Comment> comments;
    private List<Tag> tags;
}

class RegularPost extends Post {
}

class DraftPost extends Post {
}
