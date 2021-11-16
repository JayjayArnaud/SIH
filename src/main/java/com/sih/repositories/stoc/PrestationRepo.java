package com.sih.repositories.stoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.stoc.Prestation;

@Repository
public interface PrestationRepo extends JpaRepository<Prestation, Long> {

}
