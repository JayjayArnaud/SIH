package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Objet;

@Repository
public interface ObjetRepo extends JpaRepository<Objet, Long> {
	@Query(value="SELECT * FROM objet WHERE libObj like ? ", nativeQuery = true)
	public Objet getObjet(String libelle);

}
