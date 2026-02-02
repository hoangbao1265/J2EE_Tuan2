package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 3L;

    public BookService() {
        // Initialize with some sample books
        books.add(new Book(1L, "Spring Boot", "Huy Cuong"));
        books.add(new Book(2L, "Spring Boot V2", "Anh"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public void updateBook(Book updatedBook) {
        books.stream()
                .filter(b -> b.getId().equals(updatedBook.getId()))
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                });
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
