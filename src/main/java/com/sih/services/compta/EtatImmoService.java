package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.EtatImmo;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.EtatImmoRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class EtatImmoService {
	
	private final EtatImmoRepository repo;
	private final ObjetRepo objr;
	private final AgirRepo aux;
	
	public EtatImmoService(EtatImmoRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.objr = objr;
		this.aux = aux;
	}

	public List<EtatImmo> getAll(){
		return repo.findAll();
	}
	
	public EtatImmo getById(Long id) {
		return repo.findById(id).get();
	}
	public EtatImmo insert(EtatImmo elt,Utilisateur us) {
		EtatImmo nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("EtatImmo"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public EtatImmo edit(EtatImmo elt,Utilisateur us) {
		EtatImmo ancien=repo.findById(elt.getIdEtatImmo()).get();
		EtatImmo nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("EtatImmo"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		EtatImmo ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("EtatImmo"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	
}
