package org.example.dao;

import org.example.domain.Author;

public interface AuthorMapper {
    Author selectAuthorById(int id);
}
