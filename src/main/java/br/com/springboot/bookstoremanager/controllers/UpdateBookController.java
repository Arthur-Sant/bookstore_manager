package br.com.springboot.bookstoremanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.services.UpdateBookService;

@RestController
public class UpdateBookController {
  
  private UpdateBookService updateBookService;

  @Autowired
  public UpdateBookController(UpdateBookService updateBookService) {
    this.updateBookService = updateBookService;
  }

  @PutMapping("/api/v1/books/{id}")
  public MessageResponseDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
    return updateBookService.update(id, bookDTO);
  }
}
