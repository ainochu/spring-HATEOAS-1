package com.aandres.spring.examples.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookResource extends ResourceSupport {

    @NotNull
    @Size(min = 1, max = 45)
    Long isbn;

    @NotNull
    @Size(min = 1, max = 255)
    String title;


    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonCreator
    public BookResource(@JsonProperty("isbn") Long isbn, @JsonProperty("title") String title) {
        super();
        this.isbn = isbn;
        this.title = title;
    }

    public BookResource(){

    }
}
