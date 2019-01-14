package net.brndnrg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Detalle;
import net.brndnrg.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService {

	@Autowired
	private DetallesRepository detallesRepo;
	
	@Override
	public void insertar(Detalle detalle) {
		detallesRepo.save(detalle);
	}

	@Override
	public void eliminar(int idPelicula) {
		detallesRepo.deleteById(idPelicula);
		
	}

}
