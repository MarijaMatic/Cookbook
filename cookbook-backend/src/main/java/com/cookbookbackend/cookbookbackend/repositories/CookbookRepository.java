package com.cookbookbackend.cookbookbackend.repositories;

import com.cookbookbackend.cookbookbackend.models.Cookbook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookbookRepository
        extends CrudRepository<Cookbook, Long> {
   List<Cookbook> findAll();

}
