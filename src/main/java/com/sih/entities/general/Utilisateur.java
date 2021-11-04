package com.sih.entities.general;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Utilisateur implements Serializable{
	@Id
	private Long idUser;
	@Column(nullable = false, unique = true, updatable = true)
	private String login;
	@Column(nullable = false, name = "motPasse")
	private String shareCode;
	private String pass;
	private boolean onLine;
	private boolean confirm;
	private boolean confirmPass;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String shareCode, String pass, boolean onLine, boolean confirm,
			boolean confirmPass) {
		super();
		this.login = login;
		this.shareCode = shareCode;
		this.pass = pass;
		this.onLine = onLine;
		this.confirm = confirm;
		this.confirmPass = confirmPass;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public boolean isConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(boolean confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String getShareCode() {
		return shareCode;
	}

	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", login=" + login + ", shareCode=" + shareCode + ", pass=" + pass
				+ ", onLine=" + onLine + ", confirm=" + confirm + ", confirmPass=" + confirmPass + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
