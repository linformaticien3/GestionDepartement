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
public class GestionProfesseur {
	

	@Autowired
	ProfesseurDao professeurDao;
	
	@Autowired
	ModuleDao moduleDao;

	@Autowired
	ProfesseurController ProfController;
	
	@RequestMapping(value = "/ajouterProf", method = RequestMethod.POST)
	public String ajouter(Model model, @RequestParam("id_prof") int id_prof, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom) {

		professeurDao.Insert(id_prof, nom, prenom);

		return ProfController.Professeur(model);

	}

	// Ajouter , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/ajouterProfRest", method = RequestMethod.POST)
	public String ajouterEtudiantRest(Model model, @RequestParam("id_prof") int id_prof,
			@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {

		professeurDao.Insert(id_prof, nom, prenom);

		return "Opération reussite";

	}

	@RequestMapping(value = "/modifierProf", method = RequestMethod.POST)
	public String modifier(Model model, @RequestParam("id_prof") int id_prof, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom) {

		professeurDao.update(id_prof, nom, prenom);

		return ProfController.Professeur(model);

	}
	

	// Modifier , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/modifierProfRest", method = RequestMethod.POST)
	public String modifierProfRest(Model model, @RequestParam("id_prof") int id_prof,
			@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
		professeurDao.update(id_prof, nom, prenom);
		return "Opération reussite";
	}
	

	@RequestMapping(value = "/supprimerProf", method = RequestMethod.POST)
	public String supprimer(Model model, @RequestParam("id_prof") int id_prof) {

		List<Module> modules = moduleDao.findByIdprof(id_prof);

		for (int i = 0; i < modules.size(); i++) {

			moduleDao.delete(modules.get(i).getId_module());


		}
		
		professeurDao.delete(id_prof);
		return ProfController.Professeur(model);

	}
	
	
	// Supprimer , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/supprimerProfRest", method = RequestMethod.POST)
	public String supprimerRest(Model model, @RequestParam("id_prof") int id_prof) {

		List<Module> modules = moduleDao.findByIdprof(id_prof);

		for (int i = 0; i < modules.size(); i++) {

			moduleDao.delete(modules.get(i).getId_module());


		}
		
		professeurDao.delete(id_prof);
		
		return "Opération reussite";

	}

	@RequestMapping(value = "/RechercherProf", method = RequestMethod.POST)
	public String rechercher(Model model, @RequestParam("id_prof") int id_prof) {

		
		List<Professeur> profs = new ArrayList<>();

		profs.add(professeurDao.findById(id_prof));

		model.addAttribute("profs", profs);
	

		return "professeur";

	}

	// Rechercher , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/rechercherProfRest", method = RequestMethod.POST)
	public ArrayList<Professeur> rechercherEtudiantRest(@RequestParam("id_prof") int id_prof) {

		List<Professeur> profs = new ArrayList<>();

		profs.add(professeurDao.findById(id_prof));

		return (ArrayList<Professeur>) profs;

	}
	/**/
}
