package com.camilo.coffeenotebook.service;

import com.camilo.coffeenotebook.entity.Recipe;
import com.camilo.coffeenotebook.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service le dice a Spring que esta clase contiene lógica del negocio
// Spring la gestiona automáticamente — no necesitas crear instancias a mano
@Service
public class RecipeService {

    // El Repository es lo que usamos para hablar con la base de datos
    // Spring lo inyecta automáticamente gracias a @Service
    // Esto se llama "inyección de dependencias" — Spring conecta las piezas solo
    private final RecipeRepository recipeRepository;

    // Constructor — Spring llama esto automáticamente al iniciar la app
    // y le pasa el RecipeRepository ya listo para usar
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // Trae todas las recetas de la base de datos
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Busca una receta por su id
    // Optional significa "puede que exista, puede que no"
    // Evita errores si el id no existe en la BD
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    // Guarda una receta nueva en la base de datos
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // Actualiza una receta existente
    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        updatedRecipe.setId(id); // Asegura que se actualiza la correcta
        return recipeRepository.save(updatedRecipe);
    }

    // Elimina una receta por su id
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}