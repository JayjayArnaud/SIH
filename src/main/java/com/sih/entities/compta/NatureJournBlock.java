package com.sih.entities.compta;

import com.sih.entities.general.Utilisateur;

public class NatureJournBlock {
	NatureJournal natJrn;
	Utilisateur use;
	public NatureJournal getNatJrn() {
		return natJrn;
	}
	public void setNatJrn(NatureJournal natJrn) {
		this.natJrn = natJrn;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}

}
