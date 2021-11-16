package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Exercice;

@Repository
public interface ExerciceRepo extends JpaRepository<Exercice, String> {

}
