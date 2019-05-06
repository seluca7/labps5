package com.ps.lab.service.impl;

import com.ps.lab.model.Book;
import com.ps.lab.model.Item;
import com.ps.lab.repository.ItemRepository;
import com.ps.lab.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Book findByTitle(String title) {
        return itemRepository.findByTitle(title);
    }

    @Override
    public Book findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return itemRepository.findAll();
    }


    @Override
    public boolean deleteById(Long id) {
        return itemRepository.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        return itemRepository.update(book);
    }

    @Override
    public Book create(Book book) {
        return itemRepository.create(book);
    }

    @Override
    public List<Book> findByMultipleAttributes(String title, String author, String genre) {

        List<Book> books = this.findAll();


        List<Book> filteredBooks = books.stream()
                .filter( u -> (title.equals(""))|| title.equals(null)|| u.getTitle().equals(title))
                .filter( u -> author.equals("") || author.equals(null) || u.getAuthor().equals(author))
                .filter( u ->  genre.equals("") || genre.equals(null) || u.getGenre().equals(genre))
                .collect(Collectors.toList());
        return filteredBooks;
    }

    @Override
    public Book save(Book book) {
        if(book.getId()!=null){
            System.out.println("book updated");
            return itemRepository.update(book);
        }
        else{
            System.out.println("book created");
            return itemRepository.create(book);
        }
    }

}
