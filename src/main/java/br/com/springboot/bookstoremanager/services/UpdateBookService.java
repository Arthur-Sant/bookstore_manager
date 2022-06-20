package br.com.springboot.bookstoremanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.mapper.BookMapper;
import br.com.springboot.bookstoremanager.repositories.BookRepository;

@Service
public class UpdateBookService {
  private BookRepository bookRepository;

  private BookMapper bookMapper = BookMapper.INSTANCE;

  @Autowired
  public UpdateBookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public MessageResponseDTO update(Long id, BookDTO bookDTO) {

    Book book = bookMapper.toModel(bookDTO);
    
    if (bookRepository.existsById(id)) {
      
      bookRepository.save(book);

      return MessageResponseDTO
              .builder()
              .message("Book updated successfully")
              .build();
    }

    return MessageResponseDTO
            .builder()
            .message("there is no book with that id: "+ id)
            .build();
  }
}
