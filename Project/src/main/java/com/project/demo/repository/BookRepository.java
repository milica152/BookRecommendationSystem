package com.project.demo.repository;

import com.project.demo.model.Book;
import com.project.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByName(String name);
    List<Book> findAllByNameContaining(String name);
    List<Book> findAllByGenre(Genre genre);
    List<Book> findAllByRatingGreaterThan(double minRating);
    List<Book> findAllByRatingLessThanEqual(double maxRating);
}
