package com.aandres.spring.examples.loader;

import com.aandres.spring.examples.beans.Book;
import com.aandres.spring.examples.dao.BookDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    @Bean
    CommandLineRunner init(BookDAO bookDAO){
        return args -> {
            bookDAO.save(new Book(1L,"title1"));
            bookDAO.save(new Book( 2L,"title2"));
        };
    }

}
