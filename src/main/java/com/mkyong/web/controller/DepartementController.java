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

@Controller
public class DepartementController {

	@Autowired
	DepartementDao departementDao;

	@Autowired
	EtudiantDao etudiantDao;

	@RequestMapping(value = "/departement", method = RequestMethod.GET)
	public String Departement(Model model) {

		List<Departement> departements = departementDao.findAll();

		model.addAttribute("departements", departements);

		return "departement";

	}

	@ResponseBody
	@RequestMapping(value = "/departementRest", method = RequestMethod.GET)
	public ArrayList<Departement> DepartementRest(Model model) {

		List<Departement> departements = departementDao.findAll();

		return (ArrayList<com.mkyong.model.Departement>) departements;

	}

}
