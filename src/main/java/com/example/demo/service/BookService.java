package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Initialize with some sample books
        books.add(new Book(1, "Spring Boot in Action", "Craig Walls", 450000));
        books.add(new Book(2, "Java Programming", "John Doe", 350000));
        books.add(new Book(3, "Clean Code", "Robert Martin", 500000));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int id, Book updatedBook) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
