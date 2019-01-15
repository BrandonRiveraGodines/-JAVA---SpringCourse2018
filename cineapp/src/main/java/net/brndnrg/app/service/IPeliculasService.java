package net.brndnrg.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.brndnrg.app.model.Pelicula;

public interface IPeliculasService {
	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGeneros();
	//
	List<Pelicula> buscarActivas();
	List<Pelicula> buscarPorFecha(Date fecha);
	Page<Pelicula> buscarTodas(Pageable page);
	void eliminar(int idPelicula);
}
