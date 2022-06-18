package br.com.springboot.bookstoremanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.services.CreateBookService;

@RestController
public class CreateBookController {

  private CreateBookService createBookService;

  @Autowired
  public CreateBookController(CreateBookService bookService){
    this.createBookService = bookService;
  }

  @PostMapping("/api/v1/books")
  public MessageResponseDTO createBook(@RequestBody @Valid BookDTO bookDTO){
    return createBookService.create(bookDTO);
  }
  
}
