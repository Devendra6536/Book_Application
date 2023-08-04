package com.bookapplication.bookapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bookapplication.bookapplication.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

    public Book findById(int id);

    public Book findByTitle(String title);

    @Query(value = "Delete from books where books.title =:title", nativeQuery = true)
    public List<Book> deleteAllByTitle(@Param("title") String title);

}
