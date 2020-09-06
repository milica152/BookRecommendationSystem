package com.project.demo.service;

import com.project.demo.dto.PersonInfoDTO;
import com.project.demo.dto.Recommendation;
import com.project.demo.model.Book;
import com.project.demo.model.Genre;
import com.project.demo.model.GenreScore;
import com.project.demo.model.GenreWrapper;
import com.project.demo.repository.BookRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getTopTen(PersonInfoDTO personInfoDTO) {
        List<Book> all = getBooks("");
        HashMap<Genre, Integer> innerMap = new HashMap<>();
        innerMap.put(Genre.ROMANCE, 0);
        innerMap.put(Genre.CHILDREN, 0);
        innerMap.put(Genre.EDUCATION, 0);
        innerMap.put(Genre.CRIME, 0);
        innerMap.put(Genre.DRAMA, 0);
        innerMap.put(Genre.SCI_FI, 0);
        innerMap.put(Genre.BIOGRAPHY, 0);
        innerMap.put(Genre.COMEDY, 0);
        innerMap.put(Genre.COOKING, 0);
        innerMap.put(Genre.HISTORY, 0);
        innerMap.put(Genre.MUSIC, 0);
        innerMap.put(Genre.SPORT, 0);
        innerMap.put(Genre.CLASSIC, 0);
        GenreScore genreScores = new GenreScore(innerMap);

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        FactHandle handle0 = kieSession.insert(personInfoDTO);
        FactHandle handle1 = kieSession.insert(genreScores);
        kieSession.fireAllRules();

        kieSession.delete(handle1);
        kieSession.delete(handle0);   // in order to start again

        // find genre with highest value - TODO
        //
        GenreWrapper desiredGenre = new GenreWrapper(Genre.CHILDREN);
        kieSession.insert(desiredGenre);
        List<Book> allBooks = bookRepository.findAllByNameContaining("");
        for(Book b : allBooks){
            kieSession.insert(b);
        }
        kieSession.fireAllRules();

        Collection<?> objects = kieSession.getObjects();
        List<Book> result = new ArrayList<>();
        for(Object o : objects){
            if(o instanceof Book){
                result.add((Book)o);
            }
        }
        // kad se odaberu knjige odr. zanra, uzeti onda u obzir i ageOfBook zajedno sa ageGroup, takodje uzeti u obzir i ocenu knjiga
        // uzeti u obzir i kad se unese tacan zanr da samo knjige tog zanra izbacuje

        return result;
    }

    public Double getAdviseForBook(String id) {
        return 0.0;
    }

    public List<Book> getBooks(String searchParam) {
        return bookRepository.findAllByNameContaining(searchParam);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(Book book) {
        bookRepository.delete(book);
    }
}
