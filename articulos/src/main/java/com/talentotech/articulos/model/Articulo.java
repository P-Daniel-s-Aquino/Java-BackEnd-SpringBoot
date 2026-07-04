package com.talentotech.articulos.model;

import jakarta.persistence.*;

// Entidad JPA que representa un artículo en la base de datos.
@Entity
@Table(name = "articulo") // Se mapea a la tabla "articulo".
public class Articulo {

    @Id // Clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automáticamente al insertar.
    private Long id;

    // Nombre del artículo.
    private String nombre;

    // Precio del artículo.
    private Double precio;
   
    // Constructor vacío requerido por JPA.
    public Articulo() {}

    // Constructor completo para crear instancias manualmente.
    public Articulo(Long id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
   
}