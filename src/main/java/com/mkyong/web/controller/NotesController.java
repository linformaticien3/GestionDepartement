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
import com.mkyong.dao.ModuleDao;
import com.mkyong.dao.NotesDao;
import com.mkyong.dao.ProfesseurDao;
import com.mkyong.model.Etudiant;
import com.mkyong.model.Module;
import com.mkyong.model.Notes;
import com.mkyong.model.Professeur;

@Controller
public class NotesController {

	@Autowired
	NotesDao notesDao;
	
	@Autowired
	EtudiantDao etudiantDao;
	
	@Autowired
	ModuleDao moduleDao;
	
	@Autowired
	DepartementDao departementDao;
	
	@Autowired
	ProfesseurDao professeurDao;
	
	@RequestMapping(value = "/notes", method = RequestMethod.GET)
	public String Notes(Model model) {

		List<Notes> notes = notesDao.findAll();
		
		List<Module> modules = moduleDao.findAll();
		
		List<Etudiant> etudiants = etudiantDao.findAll();

		for (int i = 0; i < notes.size(); i++) {
			
			notes.get(i)
					.setEtudiant(etudiantDao.findById(notes.get(i).getEtudiant().getId_etudiant()));

			notes.get(i)
			.setModule(moduleDao.findById(notes.get(i).getModule().getId_module()));

			notes.get(i)
			.getEtudiant().setDepartement(departementDao.findById(notes.get(i).getEtudiant().getDepartement().getId_Departement()));

			notes.get(i)
			.getModule().setProf(professeurDao.findById(notes.get(i).getModule().getProf().getId_prof()));

	
	}
			
		model.addAttribute("notes", notes);
		model.addAttribute("modules", modules);
		model.addAttribute("etudiants", etudiants);

		return "note";

	}
	
	@ResponseBody
	@RequestMapping(value = "/notesRest", method = RequestMethod.GET)
	public  ArrayList<Notes> NotesRest(Model model) {

		List<Notes> notes = notesDao.findAll();
		
		//List<Professeur> profs = professeurDao.findAll();

		for (int i = 0; i < notes.size(); i++) {
			
			notes.get(i)
					.setEtudiant(etudiantDao.findById(notes.get(i).getEtudiant().getId_etudiant()));

			notes.get(i)
			.setModule(moduleDao.findById(notes.get(i).getModule().getId_module()));

			notes.get(i)
			.getEtudiant().setDepartement(departementDao.findById(notes.get(i).getEtudiant().getDepartement().getId_Departement()));

			notes.get(i)
			.getModule().setProf(professeurDao.findById(notes.get(i).getModule().getProf().getId_prof()));

	
		}
			
		//model.addAttribute("notes", notes);
		//model.addAttribute("profs", profs);

		return (ArrayList<com.mkyong.model.Notes>) notes;

	}
	
}
