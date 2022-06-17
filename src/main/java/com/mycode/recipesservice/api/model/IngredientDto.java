package com.mycode.recipesservice.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class IngredientDto {
    Long ingredientId;
    @NotBlank String ingredientName;
    int quantity;
}

