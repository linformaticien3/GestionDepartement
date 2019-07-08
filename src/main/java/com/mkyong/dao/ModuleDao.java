package com.mkyong.dao;

import java.util.List;


import com.mkyong.model.Module;


public interface ModuleDao {

	List<Module> findAll();

	Module findById(int id_module);

	void Insert(int id_module, String libelle, int id_prof);

	void update(int id_module, String libelle, int id_prof);

	void delete(int id_module);
	
	List<Module> findByIdprof(int id_prof);
	
}
