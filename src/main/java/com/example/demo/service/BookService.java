package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository br;

    public BookService(BookRepository bookRepository) {
        this.br = bookRepository;
    }

    public Book addBookToDB(Book book) {
        return br.save(book);
    }

    public List<Book> findBooksByAuthor(Author author) {
        return br.findAllByAuthors(author);
    }

}
