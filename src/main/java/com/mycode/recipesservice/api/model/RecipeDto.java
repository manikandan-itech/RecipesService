package com.mycode.recipesservice.api.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RecipeDto {
    Long recipeId;
    @NotBlank String recipeName;
    @NotNull  Long serving;
    @NotBlank String dishType;
    @NotBlank String instructions;
    @Valid List<IngredientDto> ingredients;
}
