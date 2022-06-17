package com.mycode.recipesservice.core;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycode.recipesservice.domain.Recipe;
import com.mycode.recipesservice.repository.RecipeRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRespository recipeRespository;
    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRespository.saveRecipe(recipe);
    }

    @Override
    public List<Recipe> getRecipe(Recipe recipe) {
        return recipeRespository.getRecipe(recipe);
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipeRespository.updateRecipe(recipe);
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        recipeRespository.deleteRecipe(recipeId);
    }
}
