package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    AuthorRepository ar;

    public AuthorService(AuthorRepository authorRepository) {
        this.ar = authorRepository;
    }

    public Author addAuthorToDB(Author author) {
        return ar.save(author);
    }

    public List<Author> findBooksByAuthor(Author author) {
        return ar.findAllById(author.getId());
    }


}
