package br.com.springboot.bookstoremanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.services.FindAllBooksService;

@RestController
public class FindAllBooksController {
  
  private FindAllBooksService findAllBooksService;

  @Autowired
  public FindAllBooksController(FindAllBooksService findAllBooksService) {
    this.findAllBooksService = findAllBooksService;
  }

  @GetMapping("/api/v1/books")
  public List<BookDTO> findAllBooks(){
    return findAllBooksService.findAll();
  }
}
