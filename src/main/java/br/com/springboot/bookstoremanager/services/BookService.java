package br.com.springboot.bookstoremanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.repositories.BookRepository;

@Service
public class BookService {
  
  private BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public MessageResponseDTO createBook(Book book){
    Book savedBook = bookRepository.save(book);

    return MessageResponseDTO.builder()
        .message("Book created with id: "+ savedBook.getId())
        .build();
  }

}
