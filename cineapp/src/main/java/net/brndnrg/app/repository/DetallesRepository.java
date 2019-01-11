package net.brndnrg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.brndnrg.app.model.Detalle;

@Repository
public interface DetallesRepository extends JpaRepository<Detalle, Integer> {
	
}
