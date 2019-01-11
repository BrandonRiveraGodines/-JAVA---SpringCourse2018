package net.brndnrg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.brndnrg.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

}
