package br.com.springboot.bookstoremanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.services.DeleteBookService;

@RestController
public class DeleteBookController {
  
  private DeleteBookService deleteBookService;

  @Autowired
  public DeleteBookController(DeleteBookService deleteBookService) {
    this.deleteBookService = deleteBookService;
  }

  @DeleteMapping("/api/v1/books/{id}")
  public MessageResponseDTO deleteBook(@PathVariable Long id){
    return deleteBookService.delete(id);
  }
}
