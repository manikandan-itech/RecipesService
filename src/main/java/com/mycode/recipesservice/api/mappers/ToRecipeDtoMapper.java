package com.mycode.recipesservice.api.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.api.model.RecipeDto;
import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Recipe;

public class ToRecipeDtoMapper implements Mapper<Recipe, RecipeDto> {

    private final ToIngredientDtoMapper toIngredientDtoMapper = new ToIngredientDtoMapper();
    @Override
    @NonNull
    public RecipeDto map(@NonNull Recipe source) {
        return  RecipeDto.builder()
                .recipeId(source.getRecipeId())
                .recipeName(source.getRecipeName())
                .dishType(source.getDishType())
                .instructions(source.getInstructions())
                .ingredients(toIngredientDtoMapper.map(source.getIngredients()))
                .serving(source.getServing())
                .build();
    }
}
