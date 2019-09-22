package com.cookbookbackend.cookbookbackend.controllers;

import com.cookbookbackend.cookbookbackend.models.Cookbook;
import com.cookbookbackend.cookbookbackend.repositories.CookbookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CookbookController {

    private CookbookRepository cookbookRepo;

    public CookbookController(CookbookRepository cookbookRepository){
        cookbookRepo = cookbookRepository;
    }

    @GetMapping(value = "/allCookbooks")
    public ResponseEntity<List<Cookbook>> findAllCookbooks (){
        List<Cookbook> allCookbooks = cookbookRepo.findAll();
        return new ResponseEntity<>(allCookbooks, HttpStatus.OK);
    }
}
