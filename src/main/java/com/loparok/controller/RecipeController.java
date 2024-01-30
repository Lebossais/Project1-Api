package com.loparok.controller;

import com.loparok.model.Recipe;
import com.loparok.model.User;
import com.loparok.repository.UserRepository;
import com.loparok.service.RecipeService;
import com.loparok.service.RecipeServiceImplementation;
import com.loparok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) throws Exception {

        User user=userService.findUserById(userId);

        Recipe createdRecipe = recipeService.createCecipe(recipe, null);
        return createdRecipe;
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {

        Recipe updatedRecipe = recipeService.updateRecipe(recipe, id);
        return updatedRecipe;
    }

    @GetMapping()
    public List<Recipe> getAllRecipe() throws Exception {

        List<Recipe> recipes = recipeService.findAllRecipe();
        return recipes;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "La recette a été supprimé";
    }

    @PutMapping("/{id}/like/user/{userId}")
    public Recipe likeRecipe(@PathVariable Long userId,
                             @PathVariable Long id) throws Exception {

        User user = userService.findUserById(userId);

        Recipe updatedRecipe = recipeService.likeRecipe(id, user);
        return updatedRecipe;
    }

}
