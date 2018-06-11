package com.aandres.spring.examples.controller;

import com.aandres.spring.examples.assemblers.BookResourceAssembler;
import com.aandres.spring.examples.beans.Book;
import com.aandres.spring.examples.dao.BookDAO;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;

import java.awt.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;
    private final BookResourceAssembler assembler;

    BookController(BookDAO bookDao, BookResourceAssembler assembler){
        this.bookDAO = bookDao;
        this.assembler = assembler;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resources<Resource<Book>>> findAll() {
        return ResponseEntity.ok(assembler.toResources(bookDAO.findAll()));
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resource<Book>> getByIban(@PathVariable(value="isbn") Long isbn) {

        return ResponseEntity.ok(assembler.toResource(bookDAO.findByIsbn(isbn)));
    }
}
