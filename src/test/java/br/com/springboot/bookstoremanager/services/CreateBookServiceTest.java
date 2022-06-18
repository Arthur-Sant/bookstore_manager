package br.com.springboot.bookstoremanager.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.entities.Book;
import br.com.springboot.bookstoremanager.repositories.BookRepository;
import br.com.springboot.bookstoremanager.utils.BookUtils;

@ExtendWith(MockitoExtension.class)
public class CreateBookServiceTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private FindBookByIdService findBookByIdService;

  @Test
  void whenGivenExistingIdThenReturnThisBook(){
    Book fakeBook = BookUtils.createFakeBook();

    Mockito.when(bookRepository.findById(fakeBook.getId()))
           .thenReturn(Optional.of(fakeBook));

    BookDTO bookDTO = findBookByIdService.findBydId(fakeBook.getId());

    Assertions.assertEquals(fakeBook.getName(), bookDTO.getName());
    Assertions.assertEquals(fakeBook.getIsbn(), bookDTO.getIsbn());
    Assertions.assertEquals(fakeBook.getPublisherName(), bookDTO.getPublisherName());
  }
}
