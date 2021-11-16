package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.EtatImmo;

@Repository
public interface EtatImmoRepository extends JpaRepository<EtatImmo, Long> {

}
