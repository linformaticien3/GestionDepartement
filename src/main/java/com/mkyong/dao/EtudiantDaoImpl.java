package com.mkyong.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mkyong.mapper.EtudiantMapper;
import com.mkyong.model.Etudiant;

@Repository
public class EtudiantDaoImpl implements EtudiantDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Etudiant> findAll() {

		String sql = "SELECT * FROM etudiant ";

		List<Etudiant> result = namedParameterJdbcTemplate.query(sql, new EtudiantMapper());

		return result;
	}

	@Override
	public void Insert(int id_etudiant, String nom, String prenom, int age, int id_departement) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_etudiant", id_etudiant);
		params.put("nom", nom);
		params.put("prenom", prenom);
		params.put("age", age);
		params.put("id_departement", id_departement);

		String sql = "insert into etudiant values ( :id_etudiant , :nom, :prenom,:age, :id_departement )";

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void update(int id_etudiant, String nom, String prenom, int age, int id_departement) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_etudiant", id_etudiant);
		params.put("nom", nom);
		params.put("prenom", prenom);
		params.put("age", age);
		params.put("id_departement", id_departement);

		String sql = "update etudiant set nom = :nom , prenom = :prenom , age = :age , id_departement = :id_departement where id_etudiant = :id_etudiant";

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void delete(int id_etudiant) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_etudiant", id_etudiant);

		String sql = "delete from etudiant where id_etudiant = :id_etudiant";

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public Etudiant findById(int id_Etudiant) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_Etudiant", id_Etudiant);

		String sql = "select * from etudiant where id_etudiant = :id_Etudiant";

		return namedParameterJdbcTemplate.queryForObject(sql, params, new EtudiantMapper());
	}

	@Override
	public List<Etudiant> findByIdDep(int id_Departement) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_Departement", id_Departement);

		String sql = "select * from etudiant where id_Departement = :id_Departement";

		return namedParameterJdbcTemplate.query(sql, params, new EtudiantMapper());
	}

}
