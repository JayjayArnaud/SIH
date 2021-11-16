package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.ModePaiement;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.ModePaiementRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class ModePaiementService {
	private final ModePaiementRepository repo;
	private final ObjetRepo objr;
	private final AgirRepo aux;
	
	public ModePaiementService(ModePaiementRepository repos, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repos;
		this.objr = objr;
		this.aux = aux;
	}

	
	public ModePaiement insert(ModePaiement elt,Utilisateur us) {
		ModePaiement nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("ModePaiement"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public ModePaiement edit(ModePaiement elt,Utilisateur us) {
		ModePaiement ancien=repo.findById(elt.getIdMod()).get();
		ModePaiement nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("ModePaiement"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		ModePaiement ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("ModePaiement"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public ModePaiement select(Long id){
		return repo.findById(id).get();
	}
	
	public List<ModePaiement> findByCode(String code){
		return repo.findByCodeModPay(code);
	}
	
	public List<ModePaiement> findByLibelle(String lib){
		return repo.findByLibeModPay(lib);
	}
	
	public List<ModePaiement> findAll(){
		return repo.findAll();
	}
}
