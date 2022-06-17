package com.mycode.recipesservice.domain;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class Recipe {
    Long recipeId;
    String recipeName;
    Long serving;
    String dishType;
    String instructions;
    List<Ingredient> ingredients;
}
