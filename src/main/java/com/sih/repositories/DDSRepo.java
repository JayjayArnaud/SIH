package com.sih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.DDS;

@Repository
public interface DDSRepo extends JpaRepository<DDS, Long> {
	

}
