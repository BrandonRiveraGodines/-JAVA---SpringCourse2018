package net.brndnrg.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.brndnrg.app.model.Horario;
import net.brndnrg.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService{

	@Autowired
	private HorariosRepository horariosRepo;
	
	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

}
