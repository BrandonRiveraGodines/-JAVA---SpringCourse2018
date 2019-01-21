package net.brndnrg.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.brndnrg.app.model.Pelicula;

public interface IPeliculasService {
	List<Pelicula> buscarTodas();
	Page<Pelicula> buscarTodas(Pageable page);
	Pelicula buscarPorId(int idPelicula);
	void insertar(Pelicula pelicula);
	List<String> buscarGeneros();
	void eliminar(int idPelicula);
}
