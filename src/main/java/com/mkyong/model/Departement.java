package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "departement_id", "departement_libelle", "departement_capacit�" })

public class Departement {

	@JsonProperty("departement_id")
	private int id_Departement;

	@JsonProperty("departement_libelle")
	private String libelle;

	@JsonProperty("departement_capacit�")
	private int capacit�;

	@Override
	public String toString() {
		return "id=" + id_Departement + ", libelle=" + libelle + ", capacit�=" + capacit�;
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

	public int getCapacit�() {
		return capacit�;
	}

	public void setCapacit�(int capacit�) {
		this.capacit� = capacit�;
	}

}
