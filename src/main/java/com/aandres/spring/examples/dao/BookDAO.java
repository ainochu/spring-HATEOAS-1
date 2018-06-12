package com.aandres.spring.examples.dao;

import com.aandres.spring.examples.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends JpaRepository<Book,Long> {

    Book findByIsbn(Long isbn);
}

