package com.example.kirpputori.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kirpputori.model.User.Product.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
