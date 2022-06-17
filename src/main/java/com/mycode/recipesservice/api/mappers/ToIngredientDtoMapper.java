package com.mycode.recipesservice.api.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.api.model.IngredientDto;
import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Ingredient;

public class ToIngredientDtoMapper implements Mapper<Ingredient, IngredientDto> {

    @Override
    @NonNull
    public IngredientDto map(@NonNull Ingredient source) {
        return  IngredientDto.builder()//
                .ingredientName(source.getIngredientName())//
                .ingredientId(source.getIngredientId())//
                .quantity(source.getQuantity())//
                .build();
    }
}
