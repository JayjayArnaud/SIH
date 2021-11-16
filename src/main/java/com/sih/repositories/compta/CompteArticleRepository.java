package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.CompteArticle;

@Repository
public interface CompteArticleRepository extends JpaRepository<CompteArticle, Long> {

	
	
}
