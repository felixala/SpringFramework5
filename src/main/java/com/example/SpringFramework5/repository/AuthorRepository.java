package com.example.SpringFramework5.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.SpringFramework5.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
