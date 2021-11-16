package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.Localisation;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long>{

}
