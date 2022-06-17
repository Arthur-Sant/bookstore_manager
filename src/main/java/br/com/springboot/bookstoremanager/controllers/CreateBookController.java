package br.com.springboot.bookstoremanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.services.CreateBookService;

@RestController
@RequestMapping("/api/v1/books")
public class CreateBookController {

  private CreateBookService createBookService;

  @Autowired
  public CreateBookController(CreateBookService bookService){
    this.createBookService = bookService;
  }

  @PostMapping
  public MessageResponseDTO createBook(@RequestBody @Valid BookDTO bookDTO){
    return createBookService.create(bookDTO);
  }
  
}
