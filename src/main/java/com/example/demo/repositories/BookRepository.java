package com.example.demo.repositories;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByAuthors(Author author);

}
