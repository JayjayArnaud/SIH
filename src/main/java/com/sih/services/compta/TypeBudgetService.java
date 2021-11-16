package com.sih.services.compta;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.TypeBudget;
import com.sih.entities.general.Agir;
import com.sih.entities.general.Utilisateur;
import com.sih.repositories.compta.TypBdgRepository;
import com.sih.repositories.general.AgirRepo;
import com.sih.repositories.general.ObjetRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TypeBudgetService {

        private final TypBdgRepository repo;
        private final ObjetRepo objr;
        private final AgirRepo aux;

    public TypeBudgetService(TypBdgRepository repo, ObjetRepo objr, AgirRepo aux) {
			super();
			this.repo = repo;
			this.objr = objr;
			this.aux = aux;
		}

	public List<TypeBudget> getAll(){
            return repo.findAll();
        }

        public TypeBudget getById(Long id) {
            return repo.findById(id).get();
        }

	public TypeBudget insert(TypeBudget elt,Utilisateur us) {
		TypeBudget nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("TypeBudget"));
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public TypeBudget edit(TypeBudget elt,Utilisateur us) {
		TypeBudget ancien=repo.findById(elt.getIdTypBdg()).get();
		TypeBudget nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setObj(objr.getObjet("TypeBudget"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		TypeBudget ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setObj(objr.getObjet("TypeBudget"));
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
}
