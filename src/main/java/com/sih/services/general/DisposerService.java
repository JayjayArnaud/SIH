package com.sih.services.general;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.general.Agir;
import com.sih.entities.general.Disposer;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.DisposerRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class DisposerService {
	private final DisposerRepo repo;
	private final AgirRepo aux;
	private final ObjetRepo objr;
	
	public DisposerService(DisposerRepo repo, AgirRepo aux, ObjetRepo objr) {
		super();
		this.repo = repo;
		this.aux = aux;
		this.objr = objr;
	}

	public Disposer insert(Disposer elt,Utilisateur us) {
		Disposer nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Disposer"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Disposer edit(Disposer elt,Utilisateur us) {
		Disposer ancien=repo.findById(elt.getIdDis()).get();
		Disposer nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Disposer"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Disposer ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("Disposer"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<Disposer> list(){
		return repo.findAll();
	}
	
	public Disposer select(Long id) {
		return repo.findById(id).get();
	}

}
