package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.TypeAmort;


@Repository
public interface TypeAmortRepository extends JpaRepository<TypeAmort, Long> {

}
