package com.sih.repositories.compta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sih.entities.compta.ModePaiement;

@Repository
public interface ModePaiementRepository extends JpaRepository<ModePaiement, Long>{

	List<ModePaiement> findByLibeModPay(String libeModPay);
	List<ModePaiement> findByCodeModPay(String codeModPay);
}
