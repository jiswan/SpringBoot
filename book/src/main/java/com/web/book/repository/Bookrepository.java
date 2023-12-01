package com.web.book.repository;

import com.web.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepository extends JpaRepository<Book,Long> {
}
