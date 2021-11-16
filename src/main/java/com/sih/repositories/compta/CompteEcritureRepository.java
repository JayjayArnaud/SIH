package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.CompteEcriture;

import java.util.List;

@Repository
public interface CompteEcritureRepository extends JpaRepository<CompteEcriture, Long> {

    @Query(value = "SELECT * FROM ligne_ecriture WHERE num_ecri = ? ", nativeQuery = true)
    public List<CompteEcriture> linesOf(String num);

}
