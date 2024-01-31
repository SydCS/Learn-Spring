package org.example.dao;

import org.example.domain.Blog;

public interface BlogMapper {
    Blog selectBlog(int id);
    Blog selectBlogWithDetails(int id);
}
