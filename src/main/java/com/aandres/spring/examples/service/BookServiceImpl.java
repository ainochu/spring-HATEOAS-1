package com.aandres.spring.examples.service;

import com.aandres.spring.examples.beans.Book;
import com.aandres.spring.examples.dao.BookDAO;
import com.aandres.spring.examples.dto.BookResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl {

    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    public BookResource findByIsbn(Long isbn) {
        return convert(this.bookDAO.findByIsbn(isbn));
    }


    public BookResource convert(Book book){
        return new BookResource(book.getIsbn(),book.getTitle());
    }

   public Page<BookResource> getAllBooks(Pageable pageable) {
        return new PageImpl<>(convertToResource(this.bookDAO.findAll()));
   }

   private List<BookResource> convertToResource(List<Book>bookList){
       return bookList.stream().map(temp -> {
           BookResource resource = new BookResource(temp.getIsbn(),temp.getTitle());
           return resource;
       }).collect(Collectors.toList());
   }


}
