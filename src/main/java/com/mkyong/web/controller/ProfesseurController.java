package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mkyong.model.*;
import com.mkyong.dao.ProfesseurDao;


@Controller
public class ProfesseurController {
	
	@Autowired
	ProfesseurDao professeurDao;


	@RequestMapping(value = "/professeur", method = RequestMethod.GET)
	public String Professeur(Model model) {

		List<Professeur> profs = professeurDao.findAll();

		model.addAttribute("profs", profs);

		return "professeur";

	}

	@ResponseBody
	@RequestMapping(value = "/professeurRest", method = RequestMethod.GET)
	public ArrayList<Professeur> ProfesseurRest(Model model) {

		List<Professeur> profs = professeurDao.findAll();

		return (ArrayList<com.mkyong.model.Professeur>) profs;

	}
	

}
