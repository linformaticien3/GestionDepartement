package com.mkyong.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Notes_etudiant", "Notes_module", "Notes_note" })


public class Notes {

	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	@JsonProperty("Notes_etudiant")
	  private Etudiant etudiant;
	@JsonProperty("Notes_module")
	  private Module module;
	@JsonProperty("Notes_note")
	  private double note;
}
