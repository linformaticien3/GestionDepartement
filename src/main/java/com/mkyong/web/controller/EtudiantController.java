package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.dao.DepartementDao;
import com.mkyong.dao.EtudiantDao;
import com.mkyong.model.Departement;
import com.mkyong.model.Etudiant;

@Controller
public class EtudiantController {

	@Autowired
	DepartementDao departementDao;

	@Autowired
	EtudiantDao etudiantDao;

	@RequestMapping(value = "/etudiant", method = RequestMethod.GET)
	public String Etudiant(Model model) {

		List<Etudiant> etudiants = etudiantDao.findAll();
		List<Departement> departements = departementDao.findAll();

		for (int i = 0; i < etudiants.size(); i++)
			etudiants.get(i)
					.setDepartement(departementDao.findById(etudiants.get(i).getDepartement().getId_Departement()));

		model.addAttribute("etudiants", etudiants);
		model.addAttribute("departements", departements);

		return "etudiant";

	}

	@ResponseBody
	@RequestMapping(value = "/EtudiantRest", method = RequestMethod.GET)
	public ArrayList<Etudiant> EtudiantRest(Model model) {

		List<Etudiant> etudiants = etudiantDao.findAll();

		for (int i = 0; i < etudiants.size(); i++)
			etudiants.get(i)
					.setDepartement(departementDao.findById(etudiants.get(i).getDepartement().getId_Departement()));

		return (ArrayList<com.mkyong.model.Etudiant>) etudiants;

	}

}
