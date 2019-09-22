package com.cookbookbackend.cookbookbackend.controllers;

import com.cookbookbackend.cookbookbackend.models.Recipe;
import com.cookbookbackend.cookbookbackend.repositories.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private RecipeRepository recipeRepo;

    public RecipeController (RecipeRepository recipeRepository){
        recipeRepo = recipeRepository;
    }

    @GetMapping(value = "/allRecipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        List<Recipe> allRecipes = recipeRepo.findAll();
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }

    @PostMapping(value = "/addRecipe", consumes = "application/json")
    public ResponseEntity<Recipe> writeRecipe(@RequestBody Recipe newRecipe){
        recipeRepo.save(newRecipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.OK);
    }
}
