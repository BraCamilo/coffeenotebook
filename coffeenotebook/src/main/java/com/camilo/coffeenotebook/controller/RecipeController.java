package com.camilo.coffeenotebook.controller;

import com.camilo.coffeenotebook.entity.Recipe;
import com.camilo.coffeenotebook.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController indica que esta clase recibe y responde peticiones HTTP
// Las respuestas se convierten automáticamente a formato JSON
@RestController

// @RequestMapping define la ruta base de todos los endpoints de esta clase
// Todos los endpoints de recetas empezarán con /api/recipes
@RequestMapping("/api/recipes")

// @CrossOrigin permite que el frontend (que corre en otro puerto) pueda
// hacer peticiones a este backend — sin esto el navegador las bloquea
@CrossOrigin(origins = "*")
public class RecipeController {

    // Spring inyecta el Service automáticamente
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // GET /api/recipes → devuelve todas las recetas
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    // GET /api/recipes/1 → devuelve la receta con id 1
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/recipes → crea una receta nueva
    // @RequestBody significa "lee el JSON que viene en la petición"
    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    // PUT /api/recipes/1 → actualiza la receta con id 1
    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    // DELETE /api/recipes/1 → elimina la receta con id 1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}