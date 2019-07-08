package com.mkyong.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import com.mkyong.mapper.ProfesseurMapper;
import com.mkyong.model.Professeur;

@Repository
public class ProfesseurDaoImpl implements ProfesseurDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public List<Professeur> findAll() {
		
		String sql = "SELECT * FROM prof ";

		List<Professeur> result = namedParameterJdbcTemplate.query(sql, new ProfesseurMapper());

		return result;
	}

	@Override
	public Professeur findById(int id_prof) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_prof", id_prof);

		String sql = "select * from prof where id_prof = :id_prof";

		return namedParameterJdbcTemplate.queryForObject(sql, params, new ProfesseurMapper());
	}

	@Override
	public void Insert(int id_prof, String nom, String prenom) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_prof", id_prof);
		params.put("nom", nom);
		params.put("prenom", prenom);

		String sql = "insert into prof values ( :id_prof , :nom, :prenom )";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public void update(int id_prof, String nom, String prenom) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_prof", id_prof);
		params.put("nom", nom);
		params.put("prenom", prenom);

		String sql = "update prof set nom = :nom , prenom = :prenom  where id_prof = :id_prof";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public void delete(int id_prof) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_prof", id_prof);

		String sql = "delete from prof where id_prof = :id_prof";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

}
