package com.sih.entities.compta;

import com.sih.entities.general.Utilisateur;

public class BudgetBlock {
	Budget budget;
	Utilisateur user;
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	

}
