package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.Immo;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.ImmoRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class ImmoService {

	private final ImmoRepository repo;
	private final ObjetRepo objr;
	private  final AgirRepo aux;
	
	public ImmoService(ImmoRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.objr = objr;
		this.aux = aux;
	}

	public List<Immo> getAll(){
		return repo.findAll();
	}
	
	public Immo getById(Long id) {
		return repo.findById(id).get();
	}
	
	public Immo add(Immo immo) {
		return repo.save(immo);
	}
	
	public Immo edit(Long id, Immo immo) {
		
		if(repo.existsById(id)) {
			Immo entiter = repo.findById(id).get();
			
			entiter.setActivite(immo.getActivite());
			entiter.setDatEntree(immo.getDatEntree());
			entiter.setElement(immo.getElement());
			entiter.setEtatImmo(immo.getEtatImmo());
			entiter.setIntitule(immo.getIntitule());
			entiter.setLocalisation(immo.getLocalisation());
			entiter.setNbAnne(immo.getNbAnne());
			entiter.setNbMois(immo.getNbMois());
			entiter.setNbJrs(immo.getNbJrs());
			entiter.setService(immo.getService());
			entiter.setTypeAmort(immo.getTypeAmort());
			entiter.setValAmortissable(immo.getValAmortissable());
			entiter.setValBrute(immo.getValBrute());
			entiter.setValResid(immo.getValResid());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
	
	public Immo insert(Immo elt,Utilisateur us) {
		Immo nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Immo"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Immo edit(Immo elt,Utilisateur us) {
		Immo ancien=repo.findById(elt.getIdImmo()).get();
		Immo nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("Immo"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Immo ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("Immo"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}

	
}
