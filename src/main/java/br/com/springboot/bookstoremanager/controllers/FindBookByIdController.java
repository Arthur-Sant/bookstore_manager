package br.com.springboot.bookstoremanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.services.FindBookByIdService;

@RestController
public class FindBookByIdController {

  private FindBookByIdService findBookByIdService;

  @Autowired
  public FindBookByIdController(FindBookByIdService findBookByIdService) {
    this.findBookByIdService = findBookByIdService;
  }

  @GetMapping("/api/v1/books/{id}")
  public BookDTO findBookById(@PathVariable Long id) {
    return findBookByIdService.findBydId(id);
  }


}
