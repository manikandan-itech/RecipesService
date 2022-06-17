package com.mycode.recipesservice.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.recipesservice.api.mappers.FromRecipeDtoMapper;
import com.mycode.recipesservice.api.mappers.ToRecipeDtoMapper;
import com.mycode.recipesservice.api.model.RecipeDto;
import com.mycode.recipesservice.core.RecipeService;
import com.mycode.recipesservice.domain.Ingredient;
import com.mycode.recipesservice.domain.Recipe;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/recipes")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    private final FromRecipeDtoMapper fromRecipeDtoMapper = new FromRecipeDtoMapper();
    private final ToRecipeDtoMapper toRecipeDtoMapper = new ToRecipeDtoMapper();

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RecipeDto saveRecipe(@Valid  @RequestBody RecipeDto recipeDto){
        var recipe = fromRecipeDtoMapper.map(recipeDto);
        return toRecipeDtoMapper.map(recipeService.saveRecipe(recipe));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateRecipe(@Valid @RequestBody RecipeDto recipeDto){
        var recipe = fromRecipeDtoMapper.map(recipeDto);
        recipeService.updateRecipe(recipe);
    }

    @DeleteMapping(value = "/{recipeId}", consumes = APPLICATION_JSON_VALUE)
    public void updateRecipe(@PathVariable Long recipeId){
        recipeService.deleteRecipe(recipeId);
    }

    @GetMapping
    public List<Recipe> getRecipe(@RequestParam(name = "recipeName", required = false) String recipeName,
            @RequestParam(name = "serving", required = false) Long serving,
            @RequestParam(name = "dishType", required = false) String dishType,
            @RequestParam(name = "instructions", required = false) String instructions,
            @RequestParam(name = "ingredientName", required = false) String ingredientName){
        var recipe = createRecipe(recipeName, serving, dishType, instructions, ingredientName);
        return recipeService.getRecipe(recipe);
    }

    private Recipe createRecipe(String recipeName, Long serving, String dishType, String instructions, String ingredientName) {
        return Recipe.builder()
                .recipeName(recipeName)
                .serving(serving)
                .dishType(dishType)
                .instructions(instructions)
                .ingredients(List.of(Ingredient.builder().ingredientName(ingredientName).build()))
                .build();
    }

}
