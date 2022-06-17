package com.mycode.recipesservice.repositoryJPA.mappers;

import org.springframework.lang.NonNull;

import com.mycode.recipesservice.common.mappers.Mapper;
import com.mycode.recipesservice.domain.Ingredient;
import com.mycode.recipesservice.repositoryJPA.model.IngredientEntity;

public class ToIngredientEntityMapper implements Mapper<Ingredient, IngredientEntity> {

    @Override
    @NonNull
    public IngredientEntity map(@NonNull Ingredient source) {
        var entity = new IngredientEntity();
        entity.setIngredientId(source.getIngredientId());
        entity.setIngredientName(source.getIngredientName());
        entity.setQuantity(source.getQuantity());
        return  entity;
    }
}
