package com.example.kirpputori.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.kirpputori.dataTransferObject.ApiResponse;
import com.example.kirpputori.model.User.Product.Book;
import com.example.kirpputori.repository.BookRepository;

@Service
public class BookService {

    // joko konstruktori viittaa tähä tai sit tää autowire
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    ApiResponse apiResponse;

    // public BookService(BookRepository bookRepository) {
    // this.bookRepository = bookRepository;
    // }

    public ApiResponse findAll() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return apiResponse.error("No books found");
        }
        return apiResponse.success(books);
    }

    public ApiResponse addBook(Book book) {
        try {
            if (book.getName().isEmpty() || book.getPrice() < 1) {
                return apiResponse.error("invalid parameters");
            }
            bookRepository.save(book);
            return apiResponse.success(book);
        } catch (Exception e) {
            return apiResponse.error("500, " + e.getMessage());
        }
    }

    public ApiResponse findBook(Long id) {
        try {
            Optional<Book> book = bookRepository.findById(id);
            if (book.isPresent()) {
                return apiResponse.success(book);
            }
            return apiResponse.error("invalid parameter");
        } catch (Exception e) {
            return apiResponse.error("500, " + e.getMessage());
        }
    }

}
