package com.mycode.recipesservice.repositoryJPA.repositories;

import java.util.List;

import com.mycode.recipesservice.repositoryJPA.model.RecipeEntity;

public interface RecipeEntitySearchRepository {

   List<RecipeEntity> searchAll(RecipeEntity recipeEntity);

}
