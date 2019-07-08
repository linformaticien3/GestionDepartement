package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Departement;

public interface DepartementDao {

	List<Departement> findAll();

	Departement findById(int id_Departement);

	void Insert(int id_Departement, String libelle, int capacit�);

	void update(int id_Departement, String libelle, int capacit�);

	void delete(int id_Departement);

}
