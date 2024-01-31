package com.example.mvc.controller;

import com.example.mvc.entity.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
public class HelloController {
    @Autowired
    private BookStore bookStore;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello/{id}")
    public String hello(@PathVariable("id") String msg) {
//        @RequestParam("id")
//        @RequestBody
//        @CookieValue
        System.out.println(msg);
        return "Hello!";
    }


    @GetMapping("/rest/book")
    public Book getBook() {
        return bookStore.bookList;
    }
}
