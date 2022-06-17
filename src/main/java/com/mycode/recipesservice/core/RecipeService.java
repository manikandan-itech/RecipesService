package com.mycode.recipesservice.core;

import java.util.List;

import com.mycode.recipesservice.domain.Recipe;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    List<Recipe> getRecipe(Recipe recipe);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(Long recipeId);
}
