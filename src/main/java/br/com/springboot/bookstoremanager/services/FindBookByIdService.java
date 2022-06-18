package br.com.springboot.bookstoremanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.mapper.BookMapper;
import br.com.springboot.bookstoremanager.repositories.BookRepository;

@Service
public class FindBookByIdService {
  
  private BookRepository bookRepository;

  private final BookMapper bookMapper = BookMapper.INSTANCE;

  @Autowired
  public FindBookByIdService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public BookDTO findBydId(Long id){
    Optional<Book> optionalBook = bookRepository.findById(id);
    return bookMapper.toDTO(optionalBook.get());
  }
}
