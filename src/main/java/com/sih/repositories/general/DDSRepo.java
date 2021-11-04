package com.sih.repositories.general;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.general.DDS;

@Repository
public interface DDSRepo extends JpaRepository<DDS, Long> {
	

}
