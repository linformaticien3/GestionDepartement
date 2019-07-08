package com.mkyong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mkyong.model.Etudiant;
import com.mkyong.model.Module;
import com.mkyong.model.Notes;


public class NotesMapper implements RowMapper<Notes> {

	@Override
	public Notes mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Notes note = new Notes();
		
		Etudiant E = new  Etudiant();
		E.setId_etudiant((rs.getInt("id_etudiant")));
		
		Module M = new  Module();
		M.setId_module((rs.getInt("id_module")));

		note.setEtudiant(E);
		note.setModule(M);
		note.setNote(rs.getDouble("note"));
		
		return note;
	}

}
