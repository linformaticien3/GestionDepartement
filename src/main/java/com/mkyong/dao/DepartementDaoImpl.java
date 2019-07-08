package com.mkyong.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mkyong.mapper.DepartementMapper;
import com.mkyong.model.Departement;

@Repository
public class DepartementDaoImpl implements DepartementDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Departement> findAll() {

		String sql = "SELECT * FROM Departement ";

		List<Departement> result = namedParameterJdbcTemplate.query(sql, new DepartementMapper());

		return result;

	}

	@Override
	public void Insert(int id_Departement, String libelle, int capacité) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_Departement", id_Departement);
		params.put("libelle", libelle);
		params.put("capacité", capacité);

		String sql = "insert into Departement values ( :id_Departement , :libelle, :capacité )";

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void update(int id_Departement, String libelle, int capacité) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_Departement", id_Departement);
		params.put("libelle", libelle);
		params.put("capacité", capacité);

		String sql = "update Departement set libelle =  :libelle , capacité  = :capacité where id_Departement = :id_Departement";

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public void delete(int id_Departement) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_Departement", id_Departement);

		String sql = "delete from departement where id_Departement = :id_Departement";

		namedParameterJdbcTemplate.update(sql, params);

	}

	@Override
	public Departement findById(int id_Departement) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_Departement", id_Departement);

		String sql = "select * from departement where id_Departement = :id_Departement";

		return namedParameterJdbcTemplate.queryForObject(sql, params, new DepartementMapper());

	}

}
