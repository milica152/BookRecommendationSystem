package com.project.demo.service;

import com.project.demo.dto.PersonInfoDTO;
import com.project.demo.dto.Recommendation;
import com.project.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    @Autowired
    BookRepository bookRepository;

    public Recommendation getTopTen(PersonInfoDTO personInfoDTO) {
        return new Recommendation();
    }

    public Double getAdviseForBook(String id) {
        return 0.0;
    }
}
