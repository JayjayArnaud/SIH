package com.sih.services.compta;
import org.springframework.stereotype.Service;

import com.sih.entities.compta.Budget;
import com.sih.repositories.compta.BudgetRepository;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository repo;

    public BudgetService(BudgetRepository repo) {
        this.repo = repo;
    }

    public List<Budget> getAll(){
        return repo.findAll();
    }

    public Budget getById(Long id) {
        return repo.findById(id).get();
    }

    public Budget add(Budget bdg) {
        return repo.save(bdg);
    }

    public Budget edit(Long id, Budget bdg) {

        if(repo.existsById(id)) {
            Budget entiter = repo.findById(id).get();
            entiter.setExo(bdg.getExo());
            entiter.setTypBudg(bdg.getTypBudg());

            return repo.save(entiter);
        }
        return null;
    }

    public boolean delete (Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }
}
