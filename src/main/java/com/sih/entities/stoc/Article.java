package com.sih.entities.stoc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue
	private Long idArt;

	public Article() {
		// TODO Auto-generated constructor stub
	}

}
