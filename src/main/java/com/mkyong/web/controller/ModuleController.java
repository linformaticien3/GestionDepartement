package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.dao.ModuleDao;
import com.mkyong.dao.ProfesseurDao;

import com.mkyong.model.Module;
import com.mkyong.model.Professeur;


@Controller
public class ModuleController {
	
	@Autowired
	ProfesseurDao professeurDao;

	@Autowired
	ModuleDao moduleDao;

	@RequestMapping(value = "/module", method = RequestMethod.GET)
	public String Module(Model model) {

		List<Module> modules = moduleDao.findAll();
		List<Professeur> profs = professeurDao.findAll();

		for (int i = 0; i < modules.size(); i++)
			modules.get(i)
					.setProf(professeurDao.findById(modules.get(i).getProf().getId_prof()));

		model.addAttribute("modules", modules);
		model.addAttribute("profs", profs);

		return "module";

	}

	@ResponseBody
	@RequestMapping(value = "/ModulesRest", method = RequestMethod.GET)
	public ArrayList<Module> ModuleRest(Model model) {

		List<Module> modules = moduleDao.findAll();

		for (int i = 0; i < modules.size(); i++)
			modules.get(i)
			.setProf(professeurDao.findById(modules.get(i).getProf().getId_prof()));
		
		return (ArrayList<com.mkyong.model.Module>) modules;

	}
}
