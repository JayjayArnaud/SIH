package com.sih.repositories.compta;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sih.entities.stoc.Service;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	//public List<Service> findByCodeService(String CodeService);
	
	//public List<Service> findByLibService(String LibelleService);

}
