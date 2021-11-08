package com.sih.entities.general;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class Agir implements Serializable {
	@Id
	@GeneratedValue
	private Long idActe;
	@Column(nullable = false)
	private LocalDateTime datActe;
	@Column(nullable = false)
	private String action;
	@Column(nullable = false)
	private String anciennesValeurs;
	@Column(nullable = false)
	private String nouvellesValeurs;
	
	@ManyToOne(targetEntity = Utilisateur.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false, updatable = true, insertable = true)
	private Utilisateur user;
	
	@ManyToOne(targetEntity = Objet.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idObj", referencedColumnName = "idObj", nullable = false, updatable = true, insertable = true)
	private Objet obj;

	public Agir() {
		// TODO Auto-generated constructor stub
	}

	public Agir(LocalDateTime datActe, String action, String anciennesValeurs, String nouvellesValeurs,
			Utilisateur user, Objet obj) {
		super();
		this.datActe = datActe;
		this.action = action;
		this.anciennesValeurs = anciennesValeurs;
		this.nouvellesValeurs = nouvellesValeurs;
		this.user = user;
		this.obj = obj;
	}

	public Long getIdActe() {
		return idActe;
	}

	public void setIdActe(Long idActe) {
		this.idActe = idActe;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LocalDateTime getDatActe() {
		return datActe;
	}

	public void setDatActe(LocalDateTime datActe) {
		this.datActe = datActe;
	}

	public String getAnciennesValeurs() {
		return anciennesValeurs;
	}

	public void setAnciennesValeurs(String anciennesValeurs) {
		this.anciennesValeurs = anciennesValeurs;
	}

	public String getNouvellesValeurs() {
		return nouvellesValeurs;
	}

	public void setNouvellesValeurs(String nouvellesValeurs) {
		this.nouvellesValeurs = nouvellesValeurs;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Objet getObj() {
		return obj;
	}

	public void setObj(Objet obj) {
		this.obj = obj;
	}
	
	public String element() {
		return "Agir( " + idActe + "; " + datActe + "; " + anciennesValeurs
				+ "; " + nouvellesValeurs + "; " + user + "; " + obj.getLibObj() + ")";
	}

	@Override
	public String toString() {
		return "Agir [idActe=" + idActe + ", datActe=" + datActe + ", anciennesValeurs=" + anciennesValeurs
				+ ", nouvellesValeurs=" + nouvellesValeurs + ", user=" + user + ", obj=" + obj + "]";
	}

}
