package net.brndnrg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Perfil;
import net.brndnrg.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJpa implements IPerfilesService {

	@Autowired
	private PerfilesRepository perfilesRepo;
	
	@Override
	public void guardar(Perfil perfil) {
		perfilesRepo.save(perfil);
	}

}
