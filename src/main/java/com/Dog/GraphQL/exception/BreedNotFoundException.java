package com.Dog.GraphQL.exception;


import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {
    Map<String, Object> extensions=new HashMap<>();
    public BreedNotFoundException(String breedNotFound, String breed) {
        super(breedNotFound);
        extensions.put("Breed Not Found",breed);

    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

}

