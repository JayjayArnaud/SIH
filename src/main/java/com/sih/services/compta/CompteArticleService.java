package com.sih.services.compta;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.CompteArticle;
import com.sih.entities.compta.CompteArticleBlock;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.CompteArticleRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

@Service
public class CompteArticleService {

	private final CompteArticleRepository repo;
	private final ObjetRepo objr;
	private final AgirRepo aux;
	
	public CompteArticleService(CompteArticleRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.objr = objr;
		this.aux = aux;
	}

	public List<CompteArticle> getAll(){
		return repo.findAll();
	}

	public CompteArticle selectByID(Long id) {
		return repo.findById(id).get();
	}
	
	public CompteArticle insert(CompteArticleBlock elt,Utilisateur us) {
		CompteArticle nouveau= repo.save(elt.getComArt());
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("CompteArticle"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public CompteArticle edit(CompteArticle elt,Utilisateur us) {
		CompteArticle ancien=repo.findById(elt.getIdComArt()).get();
		CompteArticle nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("CompteArticle"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		CompteArticle ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("CompteArticle"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
}
