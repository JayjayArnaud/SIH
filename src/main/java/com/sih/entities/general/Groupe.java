package com.sih.entities.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
////Il est question des groupes utilisateurs Le groupe patient ou utilisateur sera créé par défaut ainsi que le groupe admin
///Le groupe patient étant celui le plus accessible à tous
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGpe;
	@Column(unique = true, nullable = false, length = 10)
	private String codGpe;
	@Column(unique = true, nullable = false)
	private String libGpe;
	private String DescGpe; //Descrription du groupe
	
	public Groupe() {
		// TODO Auto-generated constructor stub
	}

	public Groupe(String codGpe, String libGpe, String descGpe) {
		super();
		this.codGpe = codGpe;
		this.libGpe = libGpe;
		DescGpe = descGpe;
	}

	public Long getIdGpe() {
		return idGpe;
	}

	public void setIdGpe(Long idGpe) {
		this.idGpe = idGpe;
	}

	public String getCodGpe() {
		return codGpe;
	}

	public void setCodGpe(String codGpe) {
		this.codGpe = codGpe;
	}

	public String getLibGpe() {
		return libGpe;
	}

	public void setLibGpe(String libGpe) {
		this.libGpe = libGpe;
	}

	public String getDescGpe() {
		return DescGpe;
	}

	public void setDescGpe(String descGpe) {
		DescGpe = descGpe;
	}

	@Override
	public String toString() {
		return "Groupe [idGpe=" + idGpe + ", codGpe=" + codGpe + ", libGpe=" + libGpe + ", DescGpe=" + DescGpe + "]";
	}
	
	public String element() {
		return idGpe + "; " + codGpe + "; " + libGpe + "; " + DescGpe;
	}

}
