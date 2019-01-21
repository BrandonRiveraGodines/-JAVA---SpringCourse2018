package net.brndnrg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.brndnrg.app.model.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
