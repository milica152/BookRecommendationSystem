package com.project.demo.controller;

import com.project.demo.dto.PersonInfoDTO;
import com.project.demo.dto.Recommendation;
import com.project.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;

    @PostMapping("/getTopTen")
    public ResponseEntity<Recommendation> getRecommendation(@RequestBody PersonInfoDTO personInfoDTO){
        return new ResponseEntity<>(recommendationService.getTopTen(personInfoDTO), HttpStatus.OK);
    }

    @PostMapping("/getAdviseForBook/{id}")
    public ResponseEntity<Double> getAdviseForBook(@PathVariable String id){
        return new ResponseEntity<>(recommendationService.getAdviseForBook(id), HttpStatus.OK);
    }


}
