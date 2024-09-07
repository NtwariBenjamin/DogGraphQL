package com.Dog.GraphQL.repository;

import com.Dog.GraphQL.entity.Dog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog,Long> {

    @Query(value = "delete from Dog where breed=?1", nativeQuery = true)
    long deleteByBreed(String breed);
}
