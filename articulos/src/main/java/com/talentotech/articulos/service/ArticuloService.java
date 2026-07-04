
package com.talentotech.articulos.service;

import com.talentotech.articulos.model.Articulo;
import org.springframework.lang.NonNull;
import java.util.List;
import java.util.Optional;

// Interfaz que define el contrato del servicio para gestionar artículos.
// El controlador la usa para separar la lógica de negocio de la capa web.
public interface ArticuloService {
    // Devuelve todos los artículos.
    List<Articulo> listarArticulos();

    // Devuelve un artículo por su ID, o vacío si no existe.
    Optional<Articulo> obtenerArticuloPorId(@NonNull Long id);

    // Guarda un nuevo artículo en la base de datos.
    Articulo guardarArticulo(@NonNull Articulo articulo);

    // Actualiza un artículo existente usando el ID y los datos recibidos.
    Articulo actualizarArticulo(@NonNull Long id, @NonNull Articulo articulo);

    // Elimina un artículo por su ID.
    void eliminarArticulo(@NonNull Long id);
}