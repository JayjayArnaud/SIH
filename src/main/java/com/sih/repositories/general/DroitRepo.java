package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Droit;

@Repository
public interface DroitRepo extends JpaRepository<Droit, Long> {

}
