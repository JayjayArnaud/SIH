package com.sih.services.stoc;

import org.springframework.stereotype.Service;

import com.sih.entities.stoc.ExpressionBesoin;
import com.sih.repositories.stoc.ExpressionRepo;
import com.sih.repositories.stoc.LigneEBRepo;

@Service
public class ExpressionService {
	private final ExpressionRepo eRepo;
	private final LigneEBRepo lRepo;
	
	public ExpressionService(ExpressionRepo eRepo, LigneEBRepo lRepo) {
		super();
		this.eRepo = eRepo;
		this.lRepo = lRepo;
	}
	
	public ExpressionBesoin save(ExpressionBesoin obj) {
		int rang=1;
		String debNum="EB"+obj.getExo().getCodExo()+"-%";
		if(eRepo.dernier(debNum).equals(null)) {
			rang=eRepo.dernier(debNum).getRang()+1;
		}
		obj.setRang(rang);
		return eRepo.save(obj);
	}
	
	

}
