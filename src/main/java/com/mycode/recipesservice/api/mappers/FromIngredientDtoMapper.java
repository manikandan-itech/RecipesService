package com.mycode.recipesservice.api.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.api.model.IngredientDto;
import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Ingredient;

public class FromIngredientDtoMapper implements Mapper<IngredientDto, Ingredient> {

    @Override
    @NonNull
    public Ingredient map(@NonNull IngredientDto source) {
        return  Ingredient.builder()
                .ingredientId(source.getIngredientId())
                .ingredientName(source.getIngredientName())
                .quantity(source.getQuantity())
                .build();
    }
}
