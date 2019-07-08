package com.mkyong.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import com.mkyong.mapper.ModuleMapper;
import com.mkyong.model.Module;

@Repository
public class ModuleDaoImpl implements ModuleDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Module> findAll() {

		String sql = "SELECT * FROM module ";

		List<Module> result = namedParameterJdbcTemplate.query(sql, new ModuleMapper());

		return result;
	}

	@Override
	public Module findById(int id_module) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);

		String sql = "select * from module where id_module = :id_module";
		
		return namedParameterJdbcTemplate.queryForObject(sql, params, new ModuleMapper());
		
	}

	@Override
	public void update(int id_module, String libelle, int id_prof) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		params.put("libelle", libelle);
		params.put("id_prof", id_prof);

		String sql = "update module set libelle = :libelle , id_prof = :id_prof where id_module = :id_module";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public void delete(int id_module) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);

		String sql = "delete from module where id_module = :id_module";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

	@Override
	public List<Module> findByIdprof(int id_prof) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_prof", id_prof);

		String sql = "select * from module where id_prof = :id_prof";

		return namedParameterJdbcTemplate.query(sql, params, new ModuleMapper());
	}

	@Override
	public void Insert(int id_module, String libelle, int id_prof) {
		
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_module", id_module);
		params.put("libelle", libelle);
		params.put("id_prof", id_prof);


		String sql = "insert into module values ( :id_module , :libelle, :id_prof)";

		namedParameterJdbcTemplate.update(sql, params);
		
	}

}
