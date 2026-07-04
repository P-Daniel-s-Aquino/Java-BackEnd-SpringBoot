package com.talentotech.articulos.controller;

import com.talentotech.articulos.model.Articulo;
import com.talentotech.articulos.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador REST que expone los endpoints para gestionar artículos.
// La ruta base para todas las operaciones es /api/articulos.
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen (CORS).
@RestController // Indica que la clase maneja peticiones REST y devuelve JSON.
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // GET /api/articulos
    // Devuelve la lista completa de artículos.
    @GetMapping
    public List<Articulo> listar() {
        return articuloService.listarArticulos();
    }

    // GET /api/articulos/{id}
    // Busca un artículo por su ID y devuelve 200 o 404.
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable @NonNull Long id) {
        return articuloService.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/articulos
    // Crea un nuevo artículo usando el cuerpo de la petición.
    @PostMapping
    public Articulo crear(@RequestBody @NonNull Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    // PUT /api/articulos/{id}
    // Actualiza un artículo existente. Si no existe, devuelve 404.
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable @NonNull Long id, @RequestBody @NonNull Articulo articulo) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo));
    }

    // DELETE /api/articulos/{id}
    // Elimina un artículo por ID. Devuelve 204 si se elimina con éxito.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable @NonNull Long id) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}