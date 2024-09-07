package com.Dog.GraphQL.web;

import com.Dog.GraphQL.entity.Dog;
import com.Dog.GraphQL.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    DogService dogService;
    @GetMapping("/allDogs")
    public ResponseEntity<List<Dog>> allDogs()
    {
        return new ResponseEntity<List<Dog>>(dogService.AllDogs(), HttpStatus.OK);
    }
    }
