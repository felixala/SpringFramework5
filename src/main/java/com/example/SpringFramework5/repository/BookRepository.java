package com.example.SpringFramework5.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.SpringFramework5.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
