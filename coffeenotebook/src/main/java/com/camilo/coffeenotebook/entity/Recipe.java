package com.camilo.coffeenotebook.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// @Entity le dice a Spring "esta clase representa una tabla en la base de datos"
@Entity

// @Table define el nombre exacto de la tabla en PostgreSQL
// Si no pones esto, Spring usa el nombre de la clase como nombre de tabla
@Table(name = "recipes")
public class Recipe {

    // Este será el campo "id" de la tabla — la llave primaria
    // Es como el número de cédula de cada receta, único e irrepetible
    @Id

    // Le dice a la base de datos que genere el id automáticamente
    // Cada vez que guardas una receta nueva, PostgreSQL le asigna el siguiente número
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable = false significa que este campo es obligatorio
    // Si intentas guardar una receta sin nombre, la BD rechaza el registro
    @Column(nullable = false)
    private String name;

    // Estos campos son opcionales — no tienen restricciones especiales
    private String origin;      // Ej: "Colombia", "Etiopía"
    private String method;      // Ej: "Espresso", "Pour Over", "French Press"

    // columnDefinition = "TEXT" permite textos largos sin límite de caracteres
    // String normal en PostgreSQL tiene límite, TEXT no
    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @Column(columnDefinition = "TEXT")
    private String steps;

    // Guardará la fecha y hora exacta en que se creó la receta
    private LocalDateTime createdAt;

    // @PrePersist significa "ejecuta este método justo antes de guardar en la BD"
    // Así la fecha se asigna automáticamente — tú no tienes que enviarla
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now(); // "ahora mismo"
    }

    // ---- GETTERS Y SETTERS ----
    // En Java los campos de una clase son privados (private)
    // Los getters y setters son los métodos que permiten leer y escribir esos campos
    // desde fuera de la clase.
    //
    // Getter → "dame el valor de este campo"     → getId(), getName()...
    // Setter → "cambia el valor de este campo"   → setId(), setName()...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getSteps() { return steps; }
    public void setSteps(String steps) { this.steps = steps; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}