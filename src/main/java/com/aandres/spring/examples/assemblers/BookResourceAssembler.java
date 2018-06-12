package com.aandres.spring.examples.assemblers;

import com.aandres.spring.examples.beans.Book;
import com.aandres.spring.examples.controller.BookController;

import com.aandres.spring.examples.dto.BookResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<BookResource,BookResource> {

    BookResourceAssembler(){
        super(BookController.class,BookResource.class);
    }


    @Override
    public BookResource toResource(BookResource resource) {
        resource.add(linkTo(methodOn(BookController.class).getByIban(resource.getIsbn())).withSelfRel());
        return resource;
    }
}
