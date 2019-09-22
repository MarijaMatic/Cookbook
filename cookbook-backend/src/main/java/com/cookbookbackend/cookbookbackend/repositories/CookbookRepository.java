package com.cookbookbackend.cookbookbackend.repositories;

import com.cookbookbackend.cookbookbackend.models.Cookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookbookRepository
        extends JpaRepository<Cookbook, Long> {
}
