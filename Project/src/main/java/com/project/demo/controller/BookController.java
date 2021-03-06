package com.project.demo.controller;

import com.project.demo.dto.PersonInfoDTO;
import com.project.demo.dto.Recommendation;
import com.project.demo.model.Book;
import com.project.demo.model.Genre;
import com.project.demo.model.GenreScore;
import com.project.demo.model.GenreWrapper;
import com.project.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/getTopTen")
    public ResponseEntity<List<Book>> getRecommendation(@RequestBody PersonInfoDTO personInfoDTO){
        return new ResponseEntity<>(bookService.getTopTen(personInfoDTO), HttpStatus.OK);
    }

    @PostMapping("/getAdviseForBook/{id}")
    public ResponseEntity<Double> getAdviseForBook(@PathVariable String id){
        return new ResponseEntity<>(bookService.getAdviseForBook(id), HttpStatus.OK);
    }

    @GetMapping("/findByGenre")
    public ResponseEntity<List<Book>> findByGenre(@RequestParam String param){
        System.out.println(param);
        return new ResponseEntity<>(bookService.findByGenreString(param), HttpStatus.OK);
    }

    @GetMapping("/getBySearchParam")
    public ResponseEntity<List<Book>> getAll(@RequestParam String param){
        return new ResponseEntity<>(bookService.getBooks(param), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Book book){
        bookService.removeBook(book);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
