package net.brndnrg.app.service;

import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Noticia;

@Service
public class NoticiaServiceImpl implements INoticiasService {

	// Constructor vacio, unicamente para imprimir un mensaje al crearse una instancia
	public NoticiaServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guardando el objeto " + noticia + " en la base de datos.");
	}

}
