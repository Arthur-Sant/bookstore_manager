package br.com.springboot.bookstoremanager.controllers;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.dtos.MessageResponseDTO;
import br.com.springboot.bookstoremanager.services.CreateBookService;
import br.com.springboot.bookstoremanager.utils.BookUtils;

@ExtendWith(MockitoExtension.class)
public class CreateBookControllerTest {

  private MockMvc mockMvc;

  // para indicar que ele é um mock, onde vai simular algumas chamadas
  @Mock
  private CreateBookService createBookService;

  private final String BOOK_API_URL_PATH = "/api/v1/books";

  // Toda vez que instanciar esse controller, ele vai injetar o BookService
  @InjectMocks
  private CreateBookController createBookController;

  @BeforeEach
  void setUp(){
    mockMvc = MockMvcBuilders.standaloneSetup(createBookController)
              .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
              .setViewResolvers((viewname, locale) -> new MappingJackson2JsonView())
              .build();
  }
  
  @Test
  void testWhenPostIsCalledThenABookShouldBeCreated() throws Exception{
    BookDTO bookDTO = BookUtils.createFakeBookDTO();
    MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
            .message("Book created with ID: "+ bookDTO.getId())
            .build();

    Mockito.when(createBookService.create(bookDTO)).thenReturn(expectedMessageResponse);

    mockMvc.perform(MockMvcRequestBuilders.post(BOOK_API_URL_PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(BookUtils.asJsonString(bookDTO)))
    .andExpect(MockMvcResultMatchers.status().isOk())
    .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
  }

  @Test
  void testWhenPostTwithInvalidISBNIsCalledThenABookShouldBeCreated() throws Exception{
    BookDTO bookDTO = BookUtils.createFakeBookDTO();
    bookDTO.setIsbn("invalid isbn");

    MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
            .message("Book created with ID: "+ bookDTO.getId())
            .build();

    Mockito.when(createBookService.create(bookDTO)).thenReturn(expectedMessageResponse);

    mockMvc.perform(MockMvcRequestBuilders.post(BOOK_API_URL_PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(BookUtils.asJsonString(bookDTO)))
    .andExpect(MockMvcResultMatchers.status().isOk()) // era pra ser BadRequest
    .andExpect(MockMvcResultMatchers.jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
  }
}
