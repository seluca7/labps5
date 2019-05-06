package com.ps.lab.repository;

import com.ps.lab.model.Book;
import com.ps.lab.model.Item;

import java.util.List;

public interface ItemRepository {

    List<Book> findAll();

    Book findById(Long id);

    Book create(Book book);

    Book update(Book book);

    Book findByTitle(String title);

    boolean deleteById(Long id);

}
