package br.com.springboot.bookstoremanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.bookstoremanager.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
  
}
