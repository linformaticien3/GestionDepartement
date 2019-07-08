package com.mkyong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.mkyong.model.Module;
import com.mkyong.model.Professeur;

public class ModuleMapper  implements RowMapper<Module>{
	
	

	public Module mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Module module = new Module();
		module.setId_module(rs.getInt("id_module"));
		module.setLibelle(rs.getString("libelle"));
	
	

		Professeur prof = new Professeur();
		prof.setId_prof(rs.getInt("id_prof"));
		module.setProf(prof);

		return module;
	}

}
