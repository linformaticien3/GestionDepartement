package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.mkyong.dao.ModuleDao;
import com.mkyong.dao.ProfesseurDao;
import com.mkyong.model.Module;
import com.mkyong.model.Professeur;

@Controller
public class GestionModule {
	
	@Autowired
	ModuleDao moduleDao;

	@Autowired
	ProfesseurDao professeurDao;
	
	@Autowired
	ModuleController moduleController;
	
	@RequestMapping(value = "/ajouterModule", method = RequestMethod.POST)
	public String ajouter(Model model, @RequestParam("id_module") int id_module, @RequestParam("libelle") String libelle,
			@RequestParam("id_prof") int id_prof) {

		moduleDao.Insert(id_module, libelle, id_prof);

		return moduleController.Module(model);

	}

	// Ajouter , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/ajouterModuleRest", method = RequestMethod.POST)
	public String ajouterEtudiantRest(Model model, @RequestParam("id_module") int id_module, @RequestParam("libelle") String libelle,
			@RequestParam("id_prof") int id_prof) {

		moduleDao.Insert(id_module, libelle, id_prof);

		return "Opération reussite";

	}
	
	
	@RequestMapping(value = "/modifierModule", method = RequestMethod.POST)
	public String modifier(Model model, @RequestParam("id_module") int id_module, @RequestParam("libelle") String libelle,
			@RequestParam("id_prof") int id_prof) {

		moduleDao.update(id_module, libelle, id_prof);

		return moduleController.Module(model);

	}

	// Modifier , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/modifierModuleRest", method = RequestMethod.POST)
	public String modifierEtudiantRest(Model model, @RequestParam("id_module") int id_module, @RequestParam("libelle") String libelle,
			@RequestParam("id_prof") int id_prof) {

		moduleDao.update(id_module, libelle, id_prof);
		
		return "Opération reussite";

	}
	
	@RequestMapping(value = "/supprimerModule", method = RequestMethod.POST)
	public String supprimer(Model model, @RequestParam("id_module") int id_module) {

		moduleDao.delete(id_module);
		
		return moduleController.Module(model);

	}

	// Supprimer , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/supprimerModuleRest", method = RequestMethod.POST)
	public String supprimerRest(Model model, @RequestParam("id_module") int id_module) {

		moduleDao.delete(id_module);
		
		return "Opération reussite";

	}
	
	@RequestMapping(value = "/RechercherModule", method = RequestMethod.POST)
	public String rechercher(Model model, @RequestParam("id_module") int id_module) {

		List<Module> modules = new ArrayList<>();
		List<Professeur> profs = professeurDao.findAll();

		modules.add(moduleDao.findById(id_module));

		for (int i = 0; i < modules.size(); i++)
			modules.get(i)
			.setProf(professeurDao.findById(modules.get(i).getProf().getId_prof()));
		
		model.addAttribute("modules", modules);
		model.addAttribute("profs", profs);

		return "module";

	}

	// Rechercher , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/rechercherModuleRest", method = RequestMethod.POST)
	public ArrayList<Module> rechercherEtudiantRest(Model model, @RequestParam("id_module") int id_module) {

		List<Module> modules = new ArrayList<>();
		modules.add(moduleDao.findById(id_module));
		
		for (int i = 0; i < modules.size(); i++)
			modules.get(i)
			.setProf(professeurDao.findById(modules.get(i).getProf().getId_prof()));
	
		return (ArrayList<Module>) modules;

	}
	
	@RequestMapping(value = "/RechercherModuleByProf", method = RequestMethod.POST)
	public String rechercherModuleByProf(Model model, @RequestParam("id_prof") int id_prof) {

		List<Module> modules = moduleDao.findByIdprof(id_prof);
		List<Professeur> profs = professeurDao.findAll();



		for (int i = 0; i < modules.size(); i++)
			modules.get(i)
			.setProf(professeurDao.findById(modules.get(i).getProf().getId_prof()));
		
		model.addAttribute("modules", modules);
		model.addAttribute("profs", profs);

		return "module";

	}

	// Rechercher par id prof , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/RechercherModuleByProfRest", method = RequestMethod.POST)
	public ArrayList<Module> RechercherModuleByProfRest(Model model, @RequestParam("id_prof") int id_prof) {

		List<Module> modules = moduleDao.findByIdprof(id_prof);
		
		
		for (int i = 0; i < modules.size(); i++)
			modules.get(i)
			.setProf(professeurDao.findById(modules.get(i).getProf().getId_prof()));
	
		return (ArrayList<Module>) modules;

	}


}
