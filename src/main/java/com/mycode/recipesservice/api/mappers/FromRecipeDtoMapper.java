package com.mycode.recipesservice.api.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.api.model.RecipeDto;
import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Recipe;
import com.mycode.recipesservice.repositoryJPA.mappers.FromIngredientEntityMapper;
import com.mycode.recipesservice.repositoryJPA.model.RecipeEntity;

public class FromRecipeDtoMapper implements Mapper<RecipeDto, Recipe> {

    FromIngredientDtoMapper fromIngredientDtoMapper = new FromIngredientDtoMapper();

    @Override
    @NonNull
    public Recipe map(@NonNull RecipeDto source) {
        return  Recipe.builder()
                .recipeId(source.getRecipeId())
                .dishType(source.getDishType())
                .recipeName(source.getRecipeName())
                .serving(source.getServing())
                .instructions(source.getInstructions())
                .ingredients(source.getIngredients() != null ? fromIngredientDtoMapper.map(source.getIngredients()) : null)
                .build();
    }
}
