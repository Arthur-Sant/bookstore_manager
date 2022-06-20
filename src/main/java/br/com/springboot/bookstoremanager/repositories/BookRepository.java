package br.com.springboot.bookstoremanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.springboot.bookstoremanager.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
