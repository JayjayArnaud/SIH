package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.Activite;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.ActiviteRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class ActiviteService {

	private final ActiviteRepository repo;
	private final ObjetRepo objr;
	private final AgirRepo aux;

	public ActiviteService(ActiviteRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.objr = objr;
		this.aux = aux;
	}

	public List<Activite> getAll(){
		return repo.findAll();
	}
	
	public Activite select(Long id) {
		return repo.findById(id).get();
	}
	
	public Activite insert(Activite elt,Utilisateur us) {
		Activite nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Activite"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Activite edit(Activite elt,Utilisateur us) {
		Activite ancien=repo.findById(elt.getIdAct()).get();
		Activite nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Activite"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Activite ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("Activite"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	
	
}
