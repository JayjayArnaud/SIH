package com.sih.services.compta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.TypeAmort;
import com.sih.repositories.compta.TypeAmortRepository;


@Service
public class TypeAmortService {
	
	private final TypeAmortRepository repo;

	public TypeAmortService(TypeAmortRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<TypeAmort> getAll(){
		return repo.findAll();
	}
	
	public TypeAmort getById(Long id) {
		return repo.findById(id).get();
	}
	
	public TypeAmort add(TypeAmort typeAmort) {
		return repo.save(typeAmort);
	}
	
	public TypeAmort edit(Long id, TypeAmort typeAmort) {
		
		if(repo.existsById(id)) {
			TypeAmort entiter = repo.findById(id).get();
			
			//entiter.setCodeTypAmor(typeAmort.getCodeTypAmor());
			//entiter.setLibTypAmo(typeAmort.getLibTypAmo());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
}
