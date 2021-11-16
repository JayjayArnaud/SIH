package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.Immo;

@Repository
public interface ImmoRepository extends JpaRepository<Immo, Long>{

}
