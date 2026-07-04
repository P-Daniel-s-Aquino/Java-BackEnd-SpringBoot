
package com.talentotech.articulos.service;

import com.talentotech.articulos.model.Articulo;
import com.talentotech.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Implementación del servicio que usa ArticuloRepository para acceder a datos.
@Service
public class ArticuloServiceImplement implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImplement(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }
     
    @Override
    public List<Articulo> listarArticulos() {
        // Recupera todos los artículos de la base de datos.
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerArticuloPorId(@NonNull Long id) {
        // Busca un artículo por su ID.
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo guardarArticulo(@NonNull Articulo articulo) {
        // Inserta un nuevo artículo.
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo actualizarArticulo(@NonNull Long id, @NonNull Articulo articulo) {
        // Establece el ID del artículo y guarda los cambios.
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(@NonNull Long id) {
        // Elimina el artículo con el ID especificado.
        articuloRepository.deleteById(id);
    }
}