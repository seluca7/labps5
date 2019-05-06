package com.ps.lab.service;

import com.ps.lab.model.Book;
import com.ps.lab.model.Item;

import java.util.List;

public interface ItemService {
    List<Book> findAll();

    Book findByTitle(String title);

    Book findById(Long id);

    boolean deleteById(Long id);

    Book update(Book book);

    Book create(Book book);

    List<Book> findByMultipleAttributes(String tile, String author, String genre);

    Book save(Book book);
}
