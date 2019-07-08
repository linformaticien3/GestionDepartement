package com.mkyong.dao;

import java.util.List; 

import com.mkyong.model.Etudiant;

public interface EtudiantDao {

	List<Etudiant> findAll();

	Etudiant findById(int id_Etudiant);

	List<Etudiant> findByIdDep(int id_Departement);

	void Insert(int id_etudiant, String nom, String prenom, int age, int id_departement);

	void update(int id_etudiant, String nom, String prenom, int age, int id_departement);

	void delete(int id_etudiant);

}
