package com.sih.services.general;

import java.time.LocalDateTime;
import java.util.List;

import com.sih.entities.general.Agir;
import com.sih.entities.general.UserGroup;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;
import com.sih.repositories.general.UserGroupRepo;

public class UserGroupeService {
	private final UserGroupRepo repo;
	private final AgirRepo aux;
	private final ObjetRepo objr;

	public UserGroupeService(UserGroupRepo repo, AgirRepo aux, ObjetRepo objr) {
		super();
		this.repo = repo;
		this.aux = aux;
		this.objr = objr;
	}

	public UserGroup insert(UserGroup elt,Utilisateur us) {
		UserGroup nouveau= repo.save(elt);
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
	
	public UserGroup edit(UserGroup elt,Utilisateur us) {
		UserGroup ancien=repo.findById(elt.getIdUsGpe()).get();
		UserGroup nouveau= repo.save(elt);
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
		UserGroup ancien=repo.findById(id).get();
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
	
	public List<UserGroup> list(){
		return repo.findAll();
	}
	
	public UserGroup select(Long id) {
		return repo.findById(id).get();
	}

}
