package br.com.springboot.bookstoremanager.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.springboot.bookstoremanager.dtos.BookDTO;
import br.com.springboot.bookstoremanager.entities.Book;

@Mapper
public interface BookMapper {
  
  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  Book toModel(BookDTO bookDTO);

  BookDTO toDTO(Book book);

  List<BookDTO> toDTOList(List<Book> bookList);

}
