package net.brndnrg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Usuario;
import net.brndnrg.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

}
