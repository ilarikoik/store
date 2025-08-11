package com.example.kirpputori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Product.Book;
import com.example.kirpputori.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ApiResponse findAll() {
        return bookService.findAll();
    }

    @PostMapping("/books")
    public ResponseEntity<ApiResponse> addBook(@RequestBody Book book) {
        ApiResponse response = bookService.addBook(book);

        if (!response.isSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<ApiResponse> findBook(@PathVariable Long id) {
        ApiResponse response = bookService.findBook(id);
        if (response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
