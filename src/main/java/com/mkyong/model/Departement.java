package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "departement_id", "departement_libelle", "departement_capacité" })

public class Departement {

	@JsonProperty("departement_id")
	private int id_Departement;

	@JsonProperty("departement_libelle")
	private String libelle;

	@JsonProperty("departement_capacité")
	private int capacité;

	@Override
	public String toString() {
		return "id=" + id_Departement + ", libelle=" + libelle + ", capacité=" + capacité;
	}

	public int getId_Departement() {
		return id_Departement;
	}

	public void setId_Departement(int id_Departement) {
		this.id_Departement = id_Departement;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getCapacité() {
		return capacité;
	}

	public void setCapacité(int capacité) {
		this.capacité = capacité;
	}

}
