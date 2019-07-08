package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Notes;

public interface NotesDao {
	
	List<Notes> findAll();

	List<Notes> findByIdEtuiant(int id_etudiant);

	List<Notes> findByIdModule(int id_module);
	
	List<Notes> findByIdModuleEtudiant(int id_module,int id_etudiant);
	
	void Insert(int id_module, int id_etudiant, double note);

	void update(int id_module, int id_etudiant, double note);

	void delete(int id_module, int id_etudiant);
	

	
}
