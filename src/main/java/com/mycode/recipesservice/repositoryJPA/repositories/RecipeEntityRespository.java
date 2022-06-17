package com.mycode.recipesservice.repositoryJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycode.recipesservice.repositoryJPA.model.RecipeEntity;

@Repository
public interface RecipeEntityRespository extends JpaRepository<RecipeEntity, Long>, RecipeEntitySearchRepository {
}
