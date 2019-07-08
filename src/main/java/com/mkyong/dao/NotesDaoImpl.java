package com.mkyong.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mkyong.mapper.NotesMapper;
import com.mkyong.model.Notes;

@Repository
public class NotesDaoImpl implements NotesDao{

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	
	@Override
	public List<Notes> findAll() {
		
		String sql = "SELECT * FROM note ";

		List<Notes> result = namedParameterJdbcTemplate.query(sql, new NotesMapper());

		return result;
	}

	@Override
	public List<Notes> findByIdEtuiant(int id_etudiant) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_etudiant", id_etudiant);
		
		String sql = "SELECT * FROM note where id_etudiant = :id_etudiant ";

		List<Notes> result = namedParameterJdbcTemplate.query(sql,params, new NotesMapper());

		return result;
	}

	@Override
	public List<Notes> findByIdModule(int id_module) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		
		String sql = "SELECT * FROM note where id_module = :id_module ";

		List<Notes> result = namedParameterJdbcTemplate.query(sql,params, new NotesMapper());

		return result;
	}

	@Override
	public void Insert(int id_module, int id_etudiant, double note) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		params.put("id_etudiant", id_etudiant);
		params.put("note", note);


		String sql = "insert into note values ( :id_module , :id_etudiant, :note)";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public void update(int id_module, int id_etudiant, double note) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		params.put("id_etudiant", id_etudiant);
		params.put("note", note);
		
		String sql = "update note set note = :note where id_module = :id_module and id_etudiant = :id_etudiant";

		namedParameterJdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(int id_module, int id_etudiant) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		params.put("id_etudiant", id_etudiant);

		String sql = "delete from note where id_etudiant = :id_etudiant and id_module = :id_module";

		namedParameterJdbcTemplate.update(sql, params);
		
	}


	@Override
	public List<Notes> findByIdModuleEtudiant(int id_module, int id_etudiant) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		params.put("id_etudiant", id_etudiant);
		
		String sql = "SELECT * FROM note where id_module = :id_module and id_etudiant = :id_etudiant ";

		List<Notes> result = namedParameterJdbcTemplate.query(sql,params, new NotesMapper());

		return result;
	}

}
