package com.mycode.recipesservice.repositoryJPA.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Recipe;
import com.mycode.recipesservice.repositoryJPA.model.RecipeEntity;

public class FromRecipeEntityMapper implements Mapper<RecipeEntity, Recipe> {

    FromIngredientEntityMapper fromIngredientEntityMapper = new FromIngredientEntityMapper();

    @Override
    @NonNull
    public Recipe map(@NonNull RecipeEntity source) {
        return  Recipe.builder()
                .recipeId(source.getRecipeId())
                .dishType(source.getDishType())
                .recipeName(source.getRecipeName())
                .serving(source.getServing())
                .instructions(source.getInstructions())
                .ingredients(fromIngredientEntityMapper.map(source.getIngredient()))
                .build();
    }
}
