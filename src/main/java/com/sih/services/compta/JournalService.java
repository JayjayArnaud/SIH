package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.Journal;
import com.sih.entities.compta.Compte;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.JournalRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;


@Service
public class JournalService {
	private final JournalRepository repo;
	private final ObjetRepo objr;
	private final AgirRepo aux;	

	public JournalService(JournalRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.objr = objr;
		this.aux = aux;
	}

	public List<Compte> getEligible(Long id){

		List<Compte> eligible=new ArrayList<>();
		for (Compte c:repo.findById(id).get().getCompteAutorises()){
			eligible.addAll(repo.eligible(c.getNumCpte().concat("%")));
		}
		return eligible;
	}

	public List<Journal> getAll(){
		return repo.findAll();
	}


	public List<Journal> getAutre(String cjrn){
		return repo.autreJrn(cjrn);
	}

	public Journal getById(Long id) {
		return repo.findById(id).get();
	}
		
	public Journal insert(Journal elt,Utilisateur us) {
		Journal nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Journal"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Journal edit(Journal elt,Utilisateur us) {
		Journal ancien=repo.findById(elt.getIdJrn()).get();
		Journal nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Journal"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Journal ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("Journal"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}

}
