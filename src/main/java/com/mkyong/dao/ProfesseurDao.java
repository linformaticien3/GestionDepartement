package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Professeur;

public interface ProfesseurDao {
	
	List<Professeur> findAll();

	Professeur findById(int id_prof);

	void Insert(int id_prof, String nom, String prenom);

	void update(int id_prof, String nom, String prenom);

	void delete(int id_prof);
	
}
