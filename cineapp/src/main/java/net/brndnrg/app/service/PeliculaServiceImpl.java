package net.brndnrg.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculasService {
	
	List<Pelicula> lista = null;
	
	public PeliculaServiceImpl() {
		System.out.println("Creando una instancia de la clase de servicio de peliculas");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			lista = new LinkedList<>();
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(128);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2018"));

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2018"));
			pelicula2.setImagen("bella.png");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-12-2018"));
			pelicula3.setImagen("contratiempo.png");
			pelicula3.setEstatus("Inactiva");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong la Isla Calavera");
			pelicula4.setDuracion(196);
			pelicula4.setClasificacion("A");
			pelicula4.setGenero("Aventura");
			pelicula4.setFechaEstreno(formatter.parse("30-12-2018"));
			pelicula4.setImagen("kong.png");

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");

			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
		} catch (ParseException e) {
			System.out.println("Error: ".concat(e.getMessage()));
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for(Pelicula p : lista) {
			if(p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
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
