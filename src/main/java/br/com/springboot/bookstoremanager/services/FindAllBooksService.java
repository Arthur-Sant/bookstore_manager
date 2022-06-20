package br.com.springboot.bookstoremanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.mapper.BookMapper;
import br.com.springboot.bookstoremanager.repositories.BookRepository;

@Service
public class FindAllBooksService {
  
  private BookRepository bookRepository;

  private BookMapper bookMapper = BookMapper.INSTANCE;

  @Autowired
  public FindAllBooksService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<BookDTO> findAll() {
    List<Book> books = bookRepository.findAll();

    List<BookDTO> bookDTOList = bookMapper.toDTOList(books);

    return bookDTOList;
  }
}
