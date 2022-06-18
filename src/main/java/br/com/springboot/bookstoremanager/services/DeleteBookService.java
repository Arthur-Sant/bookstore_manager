package br.com.springboot.bookstoremanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.repositories.BookRepository;

@Service
public class DeleteBookService {
  
  private BookRepository bookRepository;

  @Autowired
  public DeleteBookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public MessageResponseDTO delete(Long id){

    if( bookRepository.existsById(id) ) {
      bookRepository.deleteById(id);

      return MessageResponseDTO
                .builder()
                .message("Book deleted successfully")
                .build();
    }
    
    return MessageResponseDTO
              .builder()
              .message("there is no book with that id: "+ id)
              .build();

  }
}
