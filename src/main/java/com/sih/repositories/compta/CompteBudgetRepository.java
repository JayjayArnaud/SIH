package com.sih.repositories.compta;

import com.sih.entities.compta.CompteBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteBudgetRepository extends JpaRepository<CompteBudget, Long> {
}
