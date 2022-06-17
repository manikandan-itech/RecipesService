package com.mycode.recipesservice.api;

import com.mycode.recipesservice.api.model.RecipeDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReciptDtoTestFactory {

    public static RecipeDto createRecipeDto(String recipeName, String instructions, Long serving, String dishType) {
        return RecipeDto.builder()
                .dishType(dishType)
                .instructions(instructions)
                .serving(serving)
                .recipeName(recipeName)
                .build();
    }
}
