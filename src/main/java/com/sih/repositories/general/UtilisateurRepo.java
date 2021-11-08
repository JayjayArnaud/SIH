package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long>{

}
