package com.cookbookbackend.cookbookbackend.controllers;

import com.cookbookbackend.cookbookbackend.models.Cookbook;
import com.cookbookbackend.cookbookbackend.models.Recipe;
import com.cookbookbackend.cookbookbackend.repositories.CookbookRepository;
import com.cookbookbackend.cookbookbackend.repositories.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CookbookController {

    private CookbookRepository cookbookRepo;
    private RecipeRepository recipeRepo;

    public CookbookController(CookbookRepository cookbookRepository, RecipeRepository recipeRepository) {
        cookbookRepo = cookbookRepository;
        recipeRepo = recipeRepository;
    }

    @GetMapping(value = "/allCookbooks")
    public ResponseEntity<List<Cookbook>> findAllCookbooks() {
        List<Cookbook> allCookbooks = cookbookRepo.findAll();
        return new ResponseEntity<>(allCookbooks, HttpStatus.OK);
    }

    @PostMapping(value = "/newCookbook", consumes = "application/json")
    public ResponseEntity<Cookbook> writeCookbook(@RequestBody Cookbook newCookbook) {
        cookbookRepo.save(newCookbook);
        return new ResponseEntity<>(newCookbook, HttpStatus.OK);
    }

    @PutMapping(value = "/cookbooks/{cookbookID}/addRecipe/{recipeID}")
    public ResponseEntity<Cookbook> addRecipeToCookbook(@PathVariable Long recipeID, @PathVariable Long cookbookID) {
        Cookbook selectedCookbook = cookbookRepo.findById(cookbookID).get();
        Recipe selectedRecipe = recipeRepo.findById(recipeID).get();
        selectedCookbook.getRecipes().add(selectedRecipe);
        cookbookRepo.save(selectedCookbook);
        return new ResponseEntity<>(selectedCookbook, HttpStatus.OK);
    }
}
