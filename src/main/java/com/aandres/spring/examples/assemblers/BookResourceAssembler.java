package com.aandres.spring.examples.assemblers;

import com.aandres.spring.examples.beans.Book;
import com.aandres.spring.examples.controller.BookController;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.SimpleIdentifiableResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler extends SimpleIdentifiableResourceAssembler<Book> {

    BookResourceAssembler(){
        super(BookController.class);
    }



}
