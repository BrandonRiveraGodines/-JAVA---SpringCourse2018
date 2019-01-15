package net.brndnrg.app.service;

import java.util.List;

import net.brndnrg.app.model.Noticia;

public interface INoticiasService {
	public void guardar(Noticia noticia);
	public List<Noticia> buscarUltimas();
	public List<Noticia> buscarTodas();
	public void eliminar(int idNoticia);
	public Noticia buscarPorId(int idNoticia);
}
