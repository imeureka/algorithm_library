package com.example.demo.controllers;
import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@ResponseBody
@RequestMapping("/api")
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping(value="/search-book/{subTitle}")
    public List<Book> searchBook(@PathVariable String subTitle) {
        return bookService.searchBook(subTitle);
    }


    @GetMapping(value="search-location/{bookId}/{room}")
    public List searchLocation(@PathVariable String bookId, String room) {
        return bookService.searchLocation(bookId, room);
    }
}
