package com.sih.services.general;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.general.Agir;
import com.sih.entities.general.Exercice;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ExerciceRepo;
import com.sih.repositories.general.ObjetRepo;

@Service

public class ExerciceService {
	private final ExerciceRepo repo;
	private final AgirRepo aux;
	private final ObjetRepo objr;

	public ExerciceService(ExerciceRepo repo, AgirRepo aux, ObjetRepo objr) {
		super();
		this.repo = repo;
		this.aux = aux;
		this.objr = objr;
	}

	public Exercice insert(Exercice elt,Utilisateur us) {
		Exercice nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Exercice"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Exercice edit(Exercice elt,Utilisateur us) {
		Exercice ancien=repo.findById(elt.getCodExo()).get();
		Exercice nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Exercice"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(String id,Utilisateur us) {
		Exercice ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("Exercice"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<Exercice> list(){
		return repo.findAll();
	}
	
	public Exercice select(String id) {
		return repo.findById(id).get();
	}


}
