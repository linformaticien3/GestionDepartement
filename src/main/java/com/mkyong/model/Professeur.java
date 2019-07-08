package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "prof_id", "prof_nom", "prof_prenom"})

public class Professeur {
	
	@JsonProperty("prof_id")
	private int id_prof;

	@JsonProperty("prof_nom")
	private String nom;

	@JsonProperty("prof_prenom")
	private String prenom;

	public int getId_prof() {
		return id_prof;
	}

	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	
}
