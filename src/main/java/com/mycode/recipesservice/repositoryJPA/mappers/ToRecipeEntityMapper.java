package com.mycode.recipesservice.repositoryJPA.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Recipe;
import com.mycode.recipesservice.repositoryJPA.model.RecipeEntity;

public class ToRecipeEntityMapper implements Mapper<Recipe, RecipeEntity> {

    private final ToIngredientEntityMapper toIngredientEntityMapper = new ToIngredientEntityMapper();
    @Override
    @NonNull
    public RecipeEntity map(@NonNull Recipe source) {
        var entity = new RecipeEntity();
        entity.setRecipeId(source.getRecipeId());
        entity.setDishType(source.getDishType());
        entity.setRecipeName(source.getRecipeName());
        entity.setServing(source.getServing());
        entity.setInstructions(source.getInstructions());
        entity.setIngredient(source.getIngredients() != null ? toIngredientEntityMapper.map(source.getIngredients()) : null);
        return  entity;
    }
}
