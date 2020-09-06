package com.project.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {


    //@PostMapping("/login")
    //public ResponseEntity<String> login(){
    //     return new ResponseEntity<String>("", HttpStatus.OK);
    //}
}
