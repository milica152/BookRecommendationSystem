package com.project.demo.service;

import com.project.demo.dto.PersonInfoDTO;
import com.project.demo.dto.Recommendation;
import com.project.demo.model.Book;
import com.project.demo.model.Genre;
import com.project.demo.model.GenreScore;
import com.project.demo.repository.BookRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public GenreScore getTopTen(PersonInfoDTO personInfoDTO) {
        List<Book> all = getBooks();
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
        kieSession.insert(personInfoDTO);
        kieSession.insert(genreScores);
        kieSession.fireAllRules();
        //System.out.println(genreScores.getGenreScores().get(Genre.ROMANCE));

        // kad se odaberu knjige odr. zanra, uzeti onda u obzir i ageOfBook zajedno sa ageGroup, takodje uzeti u obzir i ocenu knjiga
        // uzeti u obzir i kad se unese tacan zanr da samo knjige tog zanra izbacuje

        return genreScores;
    }

    public Double getAdviseForBook(String id) {
        return 0.0;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(Book book) {
        bookRepository.delete(book);
    }
}
