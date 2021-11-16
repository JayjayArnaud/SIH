package com.sih.repositories.stoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sih.entities.stoc.ExpressionBesoin;

@Repository
public interface ExpressionRepo extends JpaRepository<ExpressionBesoin, String> {
	@Query(value="SELECT * FROM expression_besoin WHERE numeb like ? ORDER BY rang DESC LIMIT 1", nativeQuery = true)
	public ExpressionBesoin dernier(String debNum);

}
