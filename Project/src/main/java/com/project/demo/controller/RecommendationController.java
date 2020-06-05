package com.project.demo.controller;

import com.project.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;


}
