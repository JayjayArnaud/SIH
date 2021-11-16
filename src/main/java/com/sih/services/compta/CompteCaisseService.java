package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.CompteCaisse;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.CompteCaisseRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class CompteCaisseService {

	private final CompteCaisseRepository repo;
	private final ObjetRepo objr;
	private final AgirRepo aux;
	
	public CompteCaisseService(CompteCaisseRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.objr = objr;
		this.aux = aux;
	}

	public List<CompteCaisse> getAll(){
		return repo.findAll();
	}
	
	public CompteCaisse getById(Long id) {
		return repo.findById(id).get();
	}
	
	public CompteCaisse insert(CompteCaisse elt,Utilisateur us) {
		CompteCaisse nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("CompteCaisse"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public CompteCaisse edit(CompteCaisse elt,Utilisateur us) {
		CompteCaisse ancien=repo.findById(elt.getIdAffectComptCai()).get();
		CompteCaisse nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("CompteCaisse"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		CompteCaisse ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("CompteCaisse"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	
}
