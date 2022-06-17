package com.mycode.recipesservice.repositoryJPA.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Ingredient;
import com.mycode.recipesservice.repositoryJPA.model.IngredientEntity;

public class FromIngredientEntityMapper implements Mapper<IngredientEntity, Ingredient> {

    @Override
    @NonNull
    public Ingredient map(@NonNull IngredientEntity source) {
        return  Ingredient.builder()
                .ingredientId(source.getIngredientId())
                .ingredientName(source.getIngredientName())
                .quantity(source.getQuantity())
                .build();
    }
}
