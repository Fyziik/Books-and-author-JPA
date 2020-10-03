package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LibraryController {

    AuthorService as;
    BookService bs;

    public LibraryController(AuthorService authorService, BookService bookService) {
        this.as = authorService;
        this.bs = bookService;
    }

    @GetMapping("/")
    boolean test() {
        Author author = new Author("Doctor", "Seuss");
        Book book = new Book("The Cat in The Hat", "123213121", "idfk", author);
        Book book2 = new Book("Green egss and ham", "111111111", "yes", author);
        System.out.println(as.addAuthorToDB(author).toString());
        System.out.println(bs.addBookToDB(book).toString());
        System.out.println(bs.addBookToDB(book2).toString());

        Author author2 = new Author("Hans", "Andersen");
        Book book3 = new Book("Den grimme ælling", "222222222", "idfk", author2);
        Book book4 = new Book("Pigen med svolvstikkerne", "3333333", "idfk", author2);
        System.out.println(as.addAuthorToDB(author2).toString());
        System.out.println(bs.addBookToDB(book3).toString());
        System.out.println(bs.addBookToDB(book4).toString());

        //A book with two authors
        Book bookWithManyAuthors = new Book("Teamwork makes the dream work", "444444444", "idfk", author);
        bookWithManyAuthors.addAuthorToBook(author2);
        System.out.println(bs.addBookToDB(bookWithManyAuthors));

        System.out.println("--------Search by Author--------");

        List<Book> books = bs.findBooksByAuthor(author2);
        for (Book tmp : books) {
            System.out.println(tmp);
        }


        return true;
    }


}
