package net.brndnrg.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Pelicula;
import net.brndnrg.app.repository.DetallesRepository;
import net.brndnrg.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {

	@Autowired
	private PeliculasRepository peliculasRepo;
	
	@Autowired
	private DetallesRepository detallesRepo;

	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		detallesRepo.save(pelicula.getDetalle());
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		// Nota: Esta lista pdoría ser obtenida de una BS
		List<String> generos = new LinkedList<>();
		generos.add("Acción");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Acción y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficción");
		return generos;
	}

}
