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

import com.mkyong.dao.DepartementDao;
import com.mkyong.dao.EtudiantDao;
import com.mkyong.model.Departement;
import com.mkyong.model.Etudiant;

@Controller
public class GestionEtudiant {

	@Autowired
	DepartementDao departementDao;

	@Autowired
	EtudiantDao etudiantDao;

	@Autowired
	IndexController welcomeController;

	@Autowired
	EtudiantController EtudiantController;

	@RequestMapping(value = "/ajouterEtu", method = RequestMethod.POST)
	public String ajouter(Model model, @RequestParam("id_etudiant") int id_etudiant, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("age") int age,
			@RequestParam("id_departement") int id_departement) {

		etudiantDao.Insert(id_etudiant, nom, prenom, age, id_departement);

		// return "Opération reussite";
		return EtudiantController.Etudiant(model);

	}

	// Ajouter , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/ajouterEtuRest", method = RequestMethod.POST)
	public String ajouterEtudiantRest(Model model, @RequestParam("id_etudiant") int id_etudiant,
			@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("age") int age,
			@RequestParam("id_departement") int id_departement) {

		etudiantDao.Insert(id_etudiant, nom, prenom, age, id_departement);

		return "Opération reussite";

	}

	@RequestMapping(value = "/modifierEtu", method = RequestMethod.POST)
	public String modifier(Model model, @RequestParam("id_etudiant") int id_etudiant, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("age") int age,
			@RequestParam("id_departement") int id_departement) {

		etudiantDao.update(id_etudiant, nom, prenom, age, id_departement);

		return EtudiantController.Etudiant(model);

	}

	// Modifier , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/modifierEtuRest", method = RequestMethod.POST)
	public String modifierEtudiantRest(Model model, @RequestParam("id_etudiant") int id_etudiant,
			@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("age") int age,
			@RequestParam("id_departement") int id_departement) {

		etudiantDao.update(id_etudiant, nom, prenom, age, id_departement);
		return "Opération reussite";

	}

	@RequestMapping(value = "/supprimerEtu", method = RequestMethod.POST)
	public String supprimer(Model model, @RequestParam("id_etudiant") int id_etudiant) {

		etudiantDao.delete(id_etudiant);
		// return "Opération reussite";
		return EtudiantController.Etudiant(model);

	}

	// Supprimer , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/supprimerEtuRest", method = RequestMethod.POST)
	public String supprimerRest(Model model, @RequestParam("id_etudiant") int id_etudiant) {

		etudiantDao.delete(id_etudiant);
		return "Opération reussite";

	}

	@RequestMapping(value = "/RechercherEtu", method = RequestMethod.POST)
	public String rechercher(Model model, @RequestParam("id_etudiant") int id_etudiant) {

		List<Etudiant> etudiants = new ArrayList<>();
		List<Departement> departements = departementDao.findAll();

		etudiants.add(etudiantDao.findById(id_etudiant));

		for (int i = 0; i < etudiants.size(); i++)
			etudiants.get(i)
					.setDepartement(departementDao.findById(etudiants.get(i).getDepartement().getId_Departement()));

		model.addAttribute("etudiants", etudiants);
		model.addAttribute("departements", departements);

		return "etudiant";

	}

	// Rechercher , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/rechercherEtudiantRest", method = RequestMethod.POST)
	public ArrayList<Etudiant> rechercherEtudiantRest(@RequestParam("id_etudiant") int id_etudiant) {

		List<Etudiant> etudiants = new ArrayList<>();

		etudiants.add(etudiantDao.findById(id_etudiant));

		for (int i = 0; i < etudiants.size(); i++)
			etudiants.get(i)
					.setDepartement(departementDao.findById(etudiants.get(i).getDepartement().getId_Departement()));

		return (ArrayList<Etudiant>) etudiants;

	}

}
