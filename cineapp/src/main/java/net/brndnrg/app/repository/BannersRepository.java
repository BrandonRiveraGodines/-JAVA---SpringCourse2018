package net.brndnrg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.brndnrg.app.model.Banner;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {
	public List<Banner> findByEstatusOrderByIdDesc(String estatus);
}
