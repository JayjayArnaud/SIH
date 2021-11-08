package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.Agir;

@Repository
public interface AgirRepo extends JpaRepository<Agir, Long> {

}
