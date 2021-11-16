package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.Activite;
@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long > {

}
