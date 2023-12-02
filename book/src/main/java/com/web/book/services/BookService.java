package com.web.book.services;


import com.web.book.model.Book;
import com.web.book.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements  BookServiceInterface{
    @Autowired
    private Bookrepository bookrepository;
    public Book saveBook(Book book) {
            Book savedBook = bookrepository.save(book);
            return savedBook;
    }

    public List<Book> viewBooks() {
        return bookrepository.findAll();
    }

    public Book singleBook(Long id) {
        Book b = bookrepository.findById(id).get();
        return b;
    }

    public void deletebook(Long idk) {
        bookrepository.deleteById(idk);
    }
}
