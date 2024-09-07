package com.Dog.GraphQL.mutator;

import com.Dog.GraphQL.entity.Dog;
import com.Dog.GraphQL.exception.DogNotFoundException;
import com.Dog.GraphQL.repository.DogRepository;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogGraphQL.exception.BreedNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private DogRepository dogRepository;

    public Dog newDog(String name,String breed,String origin){
        if (name == null || name.isEmpty() || breed == null || breed.isEmpty() ||
                origin == null || origin.isEmpty()) {
            throw new IllegalArgumentException("All fields are required");
        }
        Dog dog=new Dog(name,breed,origin);
        return dogRepository.save(dog);
    }
    public Boolean deleteDog(Long id) throws DogNotFoundException{
        if (!dogRepository.existsById(id)){
            throw new DogNotFoundException("Dog ID Not Found",id);
        }
            dogRepository.deleteById(id);
            return true;

        }


    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName,Long id) throws DogNotFoundException {
        Optional<Dog> optionalDog=dogRepository.findById(id);
        if (optionalDog.isPresent()){
            Dog dog=optionalDog.get();
            dog.setName(newName);
            return dogRepository.save(dog);
        }
        else {
            throw new DogNotFoundException("Dog Not Found",id);
        }
    }
}
