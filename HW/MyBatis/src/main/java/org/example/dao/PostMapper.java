package org.example.dao;

import org.example.domain.Post;

import java.util.List;

public interface PostMapper {
    List<Post> selectPostsByBlogId(int id);
}
