package com.sih.entities.general;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Exercice implements Serializable {
	@Id
	private String codExo;
	private String libExo;
	private LocalDateTime debExo;
	private LocalDateTime finExo;
	private String etaExo;
	private boolean selectedExo;
	
	public Exercice() {
		// TODO Auto-generated constructor stub
	}

	public Exercice(String codExo, String libExo, LocalDateTime debExo, LocalDateTime finExo, String etaExo,
			boolean selectedExo) {
		super();
		this.codExo = codExo;
		this.libExo = libExo;
		this.debExo = debExo;
		this.finExo = finExo;
		this.etaExo = etaExo;
		this.selectedExo = selectedExo;
	}

	public String getCodExo() {
		return codExo;
	}

	public void setCodExo(String codExo) {
		this.codExo = codExo;
	}

	public String getLibExo() {
		return libExo;
	}

	public void setLibExo(String libExo) {
		this.libExo = libExo;
	}

	public LocalDateTime getDebExo() {
		return debExo;
	}

	public void setDebExo(LocalDateTime debExo) {
		this.debExo = debExo;
	}

	public LocalDateTime getFinExo() {
		return finExo;
	}

	public void setFinExo(LocalDateTime finExo) {
		this.finExo = finExo;
	}

	public String getEtaExo() {
		return etaExo;
	}

	public void setEtaExo(String etaExo) {
		this.etaExo = etaExo;
	}

	public boolean isSelectedExo() {
		return selectedExo;
	}

	public void setSelectedExo(boolean selectedExo) {
		this.selectedExo = selectedExo;
	}

	@Override
	public String toString() {
		return "Exercice [codExo=" + codExo + ", libExo=" + libExo + ", debExo=" + debExo + ", finExo=" + finExo
				+ ", etaExo=" + etaExo + ", selectedExo=" + selectedExo + "]";
	}
	
	public String element() {
		return codExo + "; " + libExo + "; " + debExo + "; " + finExo
				+ "; " + etaExo + "; " + selectedExo ;
	}

}
