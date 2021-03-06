package com.sih.entities.general;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class DDS implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long iddds;
@Column(unique = true, nullable = false, length = 10)
private String codDds;
@Column(unique = true, nullable = false)
private String libDds;
	
	public DDS() {
		// TODO Auto-generated constructor stub
	}

	public DDS(String codDds, String libDds) {
		super();
		this.codDds = codDds;
		this.libDds = libDds;
	}

	public Long getIddds() {
		return iddds;
	}

	public void setIddds(Long iddds) {
		this.iddds = iddds;
	}

	public String getCodDds() {
		return codDds;
	}

	public void setCodDds(String codDds) {
		this.codDds = codDds;
	}

	public String getLibDds() {
		return libDds;
	}

	public void setLibDds(String libDds) {
		this.libDds = libDds;
	}
	
	public String element() {
		return "DDS(" + iddds + "; " + codDds + "; " + libDds + ")";
	}

	@Override
	public String toString() {
		return "DDS [iddds=" + iddds + ", codDds=" + codDds + ", libDds=" + libDds + "]";
	}

}
