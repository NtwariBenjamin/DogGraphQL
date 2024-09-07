package com.Dog.GraphQL.service;

import com.Dog.GraphQL.entity.Dog;
import com.Dog.GraphQL.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    DogRepository dogRepository;
    @Override
    public List<Dog> AllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }
}
