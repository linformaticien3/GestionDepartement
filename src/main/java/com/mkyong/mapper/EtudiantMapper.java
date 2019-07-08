package com.mkyong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mkyong.dao.DepartementDao;
import com.mkyong.dao.DepartementDaoImpl;
import com.mkyong.model.Departement;
import com.mkyong.model.Etudiant;

@Component
public class EtudiantMapper implements RowMapper<Etudiant> {

	DepartementDao departementDao = new DepartementDaoImpl();

	public Etudiant mapRow(ResultSet rs, int rowNum) throws SQLException {
		Etudiant etudiant = new Etudiant();
		etudiant.setId_etudiant(rs.getInt("Id_etudiant"));
		etudiant.setNom(rs.getString("nom"));
		etudiant.setPrenom(rs.getString("prenom"));
		etudiant.setAge(rs.getInt("age"));

		Departement departement = new Departement();
		departement.setId_Departement(rs.getInt("Id_Departement"));
		etudiant.setDepartement(departement);

		return etudiant;
	}
}
