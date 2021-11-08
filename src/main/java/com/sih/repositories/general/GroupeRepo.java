package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Groupe;

@Repository
public interface GroupeRepo extends JpaRepository<Groupe, Long>{

}
