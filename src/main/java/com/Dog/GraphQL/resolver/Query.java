package com.Dog.GraphQL.resolver;

import com.Dog.GraphQL.entity.Dog;
import com.Dog.GraphQL.exception.DogNotFoundException;
import com.Dog.GraphQL.repository.DogRepository;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private DogRepository dogRepository;

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }
    public Dog findDogById(Long id){

       Optional<Dog> dog= dogRepository.findById(id);
       if (dog.isPresent()){
           return dog.get();
       }else{
           throw new DogNotFoundException("Dog ID Not Found",id);
       }
    }
}
