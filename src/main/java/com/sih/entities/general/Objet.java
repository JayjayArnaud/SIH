package com.sih.entities.general;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
/*/ Il s'agit ici d'une table dans laquelle seront repertoriées toutes les table de la base de donnée, 
 * aux fin de déterminer quel est la marge de maneouvre de chaque groupe utilisateur par rapport à chacune d'elles*/
public class Objet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idObj;
	@Column(nullable = true)
	private String codObj;
	private String libObj;
	private String descObj;
	
	public Objet() {
		// TODO Auto-generated constructor stub
	}

	public Objet(String codObj, String libObj, String descObj) {
		super();
		this.codObj = codObj;
		this.libObj = libObj;
		this.descObj = descObj; //Description de l'objet
	}

	public Long getIdObj() {
		return idObj;
	}

	public void setIdObj(Long idObj) {
		this.idObj = idObj;
	}

	public String getCodObj() {
		return codObj;
	}

	public void setCodObj(String codObj) {
		this.codObj = codObj;
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public String getDescObj() {
		return descObj;
	}

	public void setDescObj(String descObj) {
		this.descObj = descObj;
	}

	@Override
	public String toString() {
		return "Objet [idObj=" + idObj + ", codObj=" + codObj + ", libObj=" + libObj + ", descObj=" + descObj + "]";
	}

}
