package br.com.springboot.bookstoremanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.mapper.BookMapper;
import br.com.springboot.bookstoremanager.repositories.BookRepository;

@Service
public class CreateBookService {
  
  private BookRepository bookRepository;

  private final BookMapper bookMapper = BookMapper.INSTANCE;

  @Autowired
  public CreateBookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public MessageResponseDTO create(BookDTO bookDTO){
    Book bookToSave = bookMapper.toModel(bookDTO);
    
    Book savedBook = bookRepository.save(bookToSave);

    return MessageResponseDTO.builder()
        .message("Book created with id: "+ savedBook.getId())
        .build();
  }

}
