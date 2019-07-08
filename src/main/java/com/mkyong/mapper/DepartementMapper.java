package com.mkyong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mkyong.model.Departement;

public class DepartementMapper implements RowMapper<Departement> {
	public Departement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Departement departement = new Departement();
		departement.setId_Departement(rs.getInt("Id_Departement"));
		departement.setLibelle(rs.getString("libelle"));
		departement.setCapacité(rs.getInt("capacité"));
		return departement;
	}
}
