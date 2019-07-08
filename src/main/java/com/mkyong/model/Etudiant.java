package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonProperty; 
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "etudiant_id", "etudiant_nom", "etudiant_prenom", "etudiant_age", "etudiant_departement" })

public class Etudiant {

	@JsonProperty("etudiant_id")
	private int id_etudiant;

	@JsonProperty("etudiant_nom")
	private String nom;

	@JsonProperty("etudiant_prenom")
	private String prenom;

	@JsonProperty("etudiant_age")
	private int age;

	@JsonProperty("etudiant_departement")
	private Departement departement;

	public int getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
