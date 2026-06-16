package com.camilo.coffeenotebook.repository;

import com.camilo.coffeenotebook.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository le dice a Spring que esta interfaz es una capa de acceso a datos
@Repository

// Al extender JpaRepository, Spring genera automáticamente los métodos
// básicos para operar la tabla recipes:
//
// save(recipe)         → inserta o actualiza una receta
// findById(id)         → busca una receta por su id
// findAll()            → trae todas las recetas
// deleteById(id)       → elimina una receta por su id
// existsById(id)       → verifica si existe una receta con ese id
//
// JpaRepository recibe dos tipos:
//   Recipe  → la Entity sobre la que opera
//   Long    → el tipo de dato del id
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Por ahora no necesitas escribir nada aquí adentro
    // Spring implementa todos los métodos básicos automáticamente
    // Más adelante puedes agregar búsquedas personalizadas aquí

}