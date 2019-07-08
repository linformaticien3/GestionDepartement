package com.mkyong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mkyong.model.Professeur;

public class ProfesseurMapper  implements RowMapper<Professeur>  {
	

	public Professeur mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Professeur prof = new Professeur();
		
		prof.setId_prof(rs.getInt("id_prof"));
		prof.setNom(rs.getString("nom"));
		prof.setPrenom(rs.getString("prenom"));

		return prof;
	}

}
