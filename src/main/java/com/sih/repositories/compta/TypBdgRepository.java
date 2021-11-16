package com.sih.repositories.compta;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.TypeBudget;

@Repository
public interface TypBdgRepository extends JpaRepository<TypeBudget, Long> {
}
