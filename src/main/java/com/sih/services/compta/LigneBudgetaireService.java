package com.sih.services.compta;

import org.springframework.stereotype.Service;

import com.sih.entities.compta.CompteBudget;
import com.sih.repositories.compta.CompteBudgetRepository;

import java.util.List;

@Service
public class LigneBudgetaireService {

    private final CompteBudgetRepository repo;

    public LigneBudgetaireService(CompteBudgetRepository repo) {
        this.repo = repo;
    }

    public List<CompteBudget> getAll(){
        return repo.findAll();
    }

    public CompteBudget getById(Long id) {
        return repo.findById(id).get();
    }

    public CompteBudget add(CompteBudget lBdg) {
        return repo.save(lBdg);
    }

    public CompteBudget edit(Long id, CompteBudget lBdg) {

        if(repo.existsById(id)) {
            CompteBudget entiter = repo.findById(id).get();
            entiter.setExo(lBdg.getExo());
            entiter.setAccordTutel(lBdg.getAccordTutel());
            entiter.setEngagement(lBdg.getEngagement());
            entiter.setPopositionMaire(lBdg.getPopositionMaire());
            entiter.setRealisation(lBdg.getRealisation());
            entiter.setTypBdg(lBdg.getTypBdg());
            entiter.setVoteCoseil(lBdg.getVoteCoseil());
            entiter.setCpte(lBdg.getCpte());

            return repo.save(entiter);
        }
        return null;
    }

    public boolean delete (Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }
}
