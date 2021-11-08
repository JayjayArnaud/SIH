package com.sih.entities.general;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Disposer {
	@Id
	@GeneratedValue
	private Long idDis;
	private Date deb;
	private Date fin;
	
	@ManyToOne(targetEntity = Groupe.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idGpe", referencedColumnName = "idGpe", nullable = false, updatable = true, insertable = true)
	private Groupe grpe;
	
	@ManyToOne(targetEntity = Droit.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idDrt", referencedColumnName = "idDrt", nullable = false, updatable = true, insertable = true)
	private Droit drt;
	
	@ManyToOne(targetEntity = Objet.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idObj", referencedColumnName = "idObj", nullable = false, updatable = true, insertable = true)
	private Objet obj;

	public Disposer() {
		// TODO Auto-generated constructor stub
	}

	public Disposer(Date deb, Date fin, Groupe grpe, Droit drt, Objet obj) {
		super();
		this.deb = deb;
		this.fin = fin;
		this.grpe = grpe;
		this.drt = drt;
		this.obj = obj;
	}

	public Long getIdDis() {
		return idDis;
	}

	public void setIdDis(Long idDis) {
		this.idDis = idDis;
	}

	public Date getDeb() {
		return deb;
	}

	public void setDeb(Date deb) {
		this.deb = deb;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Groupe getGrpe() {
		return grpe;
	}

	public void setGrpe(Groupe grpe) {
		this.grpe = grpe;
	}

	public Droit getDrt() {
		return drt;
	}

	public void setDrt(Droit drt) {
		this.drt = drt;
	}

	public Objet getObj() {
		return obj;
	}

	public void setObj(Objet obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Disposer [idDis=" + idDis + ", deb=" + deb + ", fin=" + fin + ", grpe=" + grpe + ", drt=" + drt
				+ ", obj=" + obj + "]";
	}

	public String element() {
		return idDis + "; " + deb + "; " + fin + "; " + grpe + "; " + drt.getLibDrt()+ "; " + obj.getLibObj();
	}

}
