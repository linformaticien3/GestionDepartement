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
public class GestionDepartement {

	@Autowired
	DepartementDao departementDao;

	@Autowired
	EtudiantDao etudiantDao;

	@Autowired
	IndexController welcomeController;

	@Autowired
	DepartementController depart;

	@RequestMapping(value = "/ajouterDep", method = RequestMethod.POST)
	public String ajouter(Model model, @RequestParam("id_Departement") int id_Departement,
			@RequestParam("libelle") String libelle, @RequestParam("capacite") int capacité) {

		departementDao.Insert(id_Departement, libelle, capacité);

		return depart.Departement(model);

	}

	// Ajouter , Rest WebServices
	@ResponseBody
	@RequestMapping(value = "/ajouterDepRest", method = RequestMethod.POST)
	public String ajouterDepRest(Model model, @RequestParam("id_Departement") int id_Departement,
			@RequestParam("libelle") String libelle, @RequestParam("capacite") int capacité) {

		departementDao.Insert(id_Departement, libelle, capacité);

		return "Opération Réussite";

	}

	@RequestMapping(value = "/modifierDep", method = RequestMethod.POST)
	public String modifier(Model model, @RequestParam("id_Departement") int id_Departement,
			@RequestParam("libelle") String libelle, @RequestParam("capacite") int capacité) {

		departementDao.update(id_Departement, libelle, capacité);

		return depart.Departement(model);

	}

	// modifier , Rest WebServices
	@ResponseBody
	@RequestMapping(value = "/modifierDepRest", method = RequestMethod.POST)
	public String modifierDepRest(Model model, @RequestParam("id_Departement") int id_Departement,
			@RequestParam("libelle") String libelle, @RequestParam("capacite") int capacité) {

		departementDao.update(id_Departement, libelle, capacité);

		return "Opération Réussite";

	}

	@RequestMapping(value = "/supprimerDep", method = RequestMethod.POST)
	public String supprimer(Model model, @RequestParam("id_Departement") int id_Departement) {

		List<Etudiant> etudiants = etudiantDao.findByIdDep(id_Departement);

		for (int i = 0; i < etudiants.size(); i++) {

			etudiantDao.delete(etudiants.get(i).getId_etudiant());

			// System.out.println(etudiants.get(i).getId_etudiant() + " " +
			// etudiants.get(i).getNom() + " "
			// + etudiants.get(i).getPrenom() + " " + etudiants.get(i).getAge()
			// + " " + -1);
		}
		departementDao.delete(id_Departement);

		return depart.Departement(model);
	}

	// modifier , Rest WebServices
	@ResponseBody
	@RequestMapping(value = "/supprimerDepRest", method = RequestMethod.POST)
	public String supprimerRest(Model model, @RequestParam("id_Departement") int id_Departement) {

		List<Etudiant> etudiants = etudiantDao.findByIdDep(id_Departement);

		for (int i = 0; i < etudiants.size(); i++) {

			etudiantDao.delete(etudiants.get(i).getId_etudiant());

			// System.out.println(etudiants.get(i).getId_etudiant() + " " +
			// etudiants.get(i).getNom() + " "
			// + etudiants.get(i).getPrenom() + " " + etudiants.get(i).getAge()
			// + " " + -1);
		}
		departementDao.delete(id_Departement);

		return "Opération Réussite";
	}

	@RequestMapping(value = "/rechercherDep", method = RequestMethod.POST)
	public String rechercher(Model model, @RequestParam("id_departement") int id_departement) {

		List<Departement> departements = new ArrayList<>();

		departements.add(departementDao.findById(id_departement));

		// System.out.println(departements.get(0).getLibelle());

		model.addAttribute("departements", departements);

		return "departement";

	}

	// Rechercher , Rest WebServices
	@ResponseBody
	@RequestMapping(value = "/rechercherDepartementRest", method = RequestMethod.POST)
	public ArrayList<Departement> rechercherDepRest(Model model, @RequestParam("id_departement") int id_departement) {

		List<Departement> departements = new ArrayList<>();

		departements.add(departementDao.findById(id_departement));

		return (ArrayList<Departement>) departements;

	}

}
