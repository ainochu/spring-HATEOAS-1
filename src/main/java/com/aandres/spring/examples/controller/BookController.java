package com.aandres.spring.examples.controller;

import com.aandres.spring.examples.assemblers.BookResourceAssembler;
import com.aandres.spring.examples.beans.Book;
import com.aandres.spring.examples.dao.BookDAO;
import com.aandres.spring.examples.dto.BookResource;
import com.aandres.spring.examples.service.BookServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookService;
    private final BookResourceAssembler assembler;

    BookController(BookServiceImpl bookService, BookResourceAssembler assembler){
        this.bookService = bookService;
        this.assembler = assembler;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Page<BookResource>> findAll(@PageableDefault( sort = "isbn", direction = Sort.Direction.ASC)
                                                                    final Pageable pageable){
        //return ResponseEntity.ok(bookService.getAllBooks(pageable));
        return ResponseEntity.ok(new PageImpl<>(assembler.toResources(bookService.getAllBooks(pageable))));
    }


    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<BookResource> getByIban(@PathVariable(value="isbn") Long isbn) {

        return ResponseEntity.ok(assembler.toResource(bookService.findByIsbn(isbn)));
    }


}
