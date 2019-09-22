package com.cookbookbackend.cookbookbackend.repositories;

import com.cookbookbackend.cookbookbackend.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository
        extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();
}
