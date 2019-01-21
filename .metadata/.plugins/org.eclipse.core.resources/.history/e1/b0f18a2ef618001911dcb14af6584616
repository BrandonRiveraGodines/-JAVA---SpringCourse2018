package net.brndnrg.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.brndnrg.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	List<Noticia> findByEstatus(String estatus);
	List<Noticia> findByFecha(Date date);
	List<Noticia> findByEstatusAndFecha(String estatus, Date date);
	List<Noticia> findByEstatusOrFecha(String estatus, Date date);
	List<Noticia> findByFechaBetween(Date fechaInicio, Date fechaFin);
}
