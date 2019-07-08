package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "module_id", "module_libelle", "module_idProf" })


public class Module {
	
	  @JsonProperty("module_id")
	  private int id_module;
	  @JsonProperty("module_libelle")
	  private String libelle;
	  @JsonProperty("module_idProf")
	  private Professeur prof;
	  
	public Professeur getProf() {
		return prof;
	}
	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	public int getId_module() {
		return id_module;
	}
	public void setId_module(int id_module) {
		this.id_module = id_module;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}
