package com.web.book.controller;

import com.web.book.model.Book;
import com.web.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //Create Method
    @PostMapping("/save")
    public ResponseEntity<Book> saveEmployee ( @RequestBody Book book)
    {
       Book booksaved =  bookService.saveBook(book);
       return new ResponseEntity<>(booksaved, HttpStatus.CREATED);
    }

    //Read Method
    @GetMapping("/viewbooks")
    public ResponseEntity<List<Book>>viewBooks()
    {
        List<Book> viewAll = bookService.viewBooks();
        return new ResponseEntity<>(viewAll,HttpStatus.OK);
    }


    @GetMapping("/viewbooks/{id}")
    public ResponseEntity<Book> singleBook(@PathVariable("id") Long idk)
    {
        Book oneBook = bookService.singleBook(idk);
        return new ResponseEntity<>(oneBook,HttpStatus.OK);
    }

    //Delete Method
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long idk)
    {
        bookService.deletebook(idk);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //Update Method

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book)
    {
        Book b =bookService.saveBook(book);
        return  new ResponseEntity<>(b,HttpStatus.OK);
    }

}
