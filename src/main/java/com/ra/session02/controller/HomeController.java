package com.ra.session02.controller;

import com.ra.session02.model.dto.Hello;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping
    public ResponseEntity<Hello> home(){
        Hello hello = new Hello("Xin chào bạn đến với API");
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}
