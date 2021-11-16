package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.CompteCaisse;

@Repository
public interface CompteCaisseRepository extends JpaRepository<CompteCaisse, Long> {

}
