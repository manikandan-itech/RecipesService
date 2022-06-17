package com.mycode.recipesservice.repositoryJPA.model;

import static com.mycode.recipesservice.repositoryJPA.model.IngredientEntityTestFactory.ingredientEntity;
import static lombok.AccessLevel.PRIVATE;

import java.util.List;

import com.mycode.recipesservice.domain.DishType;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class RecipeEntityTestFactory {

    public static RecipeEntity recipeEntity() {

        var entity = new RecipeEntity();
        entity.setRecipeName("RecipeName");
        entity.setServing(4L);
        entity.setDishType(DishType.VEGETARIAN.name());
        entity.setInstructions("Instructions");
        entity.setIngredient(List.of(ingredientEntity()));
        return entity;
    }
}
