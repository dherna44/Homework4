package com.homework4API.homework4API.Models;

import org.springframework.data.repository.CrudRepository;

//Interface that allows for CRUD functionality within the database:
public interface ChuckJokesRepo extends CrudRepository<ChuckJokes, String> {
}
