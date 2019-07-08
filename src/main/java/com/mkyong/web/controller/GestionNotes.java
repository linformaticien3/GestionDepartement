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
import com.mkyong.dao.ModuleDao;
import com.mkyong.dao.NotesDao;
import com.mkyong.dao.ProfesseurDao;
import com.mkyong.model.Etudiant;
import com.mkyong.model.Module;
import com.mkyong.model.Notes;
import com.mkyong.model.Professeur;

@Controller
public class GestionNotes {
	
	@Autowired
	NotesDao notesDao;
	
	@Autowired
	NotesController notesController;
	
	@Autowired
	EtudiantDao etudiantDao;
	
	@Autowired
	ModuleDao moduleDao;
	
	@Autowired
	DepartementDao departementDao;
	
	@Autowired
	ProfesseurDao professeurDao;

	
	@RequestMapping(value = "/ajouterNotes", method = RequestMethod.POST)
	public String ajouter(Model model, @RequestParam("id_etudiant") int id_etudiant, @RequestParam("id_module") int id_module,
			@RequestParam("note") double note) {

		notesDao.Insert(id_module, id_etudiant, note);

		return notesController.Notes(model);

	}

	// Ajouter , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/ajouterNotesRest", method = RequestMethod.POST)
	public String ajouterRest(Model model, @RequestParam("id_etudiant") int id_etudiant, @RequestParam("id_module") int id_module,
			@RequestParam("note") double note) {

		notesDao.Insert(id_module, id_etudiant, note);

		return "Opération reussite";

	}
	
	@RequestMapping(value = "/modifierNote", method = RequestMethod.POST)
	public String modifier(Model model, @RequestParam("id_etudiant") int id_etudiant, @RequestParam("id_module") int id_module,
			@RequestParam("note") double note) {

		notesDao.update(id_module, id_etudiant, note);

		return notesController.Notes(model);

	}

	// Modifier , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/modifierNoteRest", method = RequestMethod.POST)
	public String modifierNoteRest(Model model, @RequestParam("id_etudiant") int id_etudiant, @RequestParam("id_module") int id_module,
			@RequestParam("note") double note) {

		notesDao.update(id_module, id_etudiant, note);
		
		return "Opération reussite";

	}
		
	@RequestMapping(value = "/supprimerNote", method = RequestMethod.POST)
	public String supprimer(Model model, @RequestParam("id_module") int id_module,@RequestParam("id_etudiant") int id_etudiant) {

		notesDao.delete(id_module, id_etudiant);
		
		return notesController.Notes(model);

	}
	
	// Supprimer , Rest Webservices
	@ResponseBody
	@RequestMapping(value = "/supprimerNoteRest", method = RequestMethod.POST)
	public String supprimerNoteRest(Model model, @RequestParam("id_module") int id_module,@RequestParam("id_etudiant") int id_etudiant) {

		notesDao.delete(id_module, id_etudiant);
		
		return "Opération reussite";

	}

	@RequestMapping(value = "/RechercherNoteByEtudiant", method = RequestMethod.POST)
	public String rechercherByEtudiant(Model model, @RequestParam("id_etudiant") int id_etudiant) {

		List<Notes> notes = notesDao.findByIdEtuiant(id_etudiant);
		
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

	// Rechercher par un etudiant , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/RechercherNoteByEtudiantRest", method = RequestMethod.POST)
	public ArrayList<Notes> rechercherByEtudiantRest(Model model, @RequestParam("id_etudiant") int id_etudiant) {

		List<Notes> notes = notesDao.findByIdEtuiant(id_etudiant);
		

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
	
			
		
		return (ArrayList<Notes>) notes;

	}	
	
	@RequestMapping(value = "/RechercherNoteByModule", method = RequestMethod.POST)
	public String rechercherByModule(Model model, @RequestParam("id_module") int id_module) {

		List<Notes> notes = notesDao.findByIdModule(id_module);
		
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

	// Rechercher par un module , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/RechercherNoteByModuleRest", method = RequestMethod.POST)
	public ArrayList<Notes> rechercherByModuleRest(Model model, @RequestParam("id_module") int id_module) {

		List<Notes> notes = notesDao.findByIdModule(id_module);
		

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
	
			
		
		return (ArrayList<Notes>) notes;

	}	
	
	@RequestMapping(value = "/RechercherNoteByModuleEtudiant", method = RequestMethod.POST)
	public String rechercherByModuleEtudiant(Model model, @RequestParam("id_module") int id_module,@RequestParam("id_etudiant") int id_etudiant) {

		List<Notes> notes = notesDao.findByIdModuleEtudiant(id_module, id_etudiant);
		
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

	// Rechercher par un module , Rest WerbServices
	@ResponseBody
	@RequestMapping(value = "/RechercherNoteByModuleEtudiantRest", method = RequestMethod.POST)
	public ArrayList<Notes> rechercherByModuleEtudiantRest(Model model, @RequestParam("id_module") int id_module,@RequestParam("id_etudiant") int id_etudiant) {

		List<Notes> notes = notesDao.findByIdModuleEtudiant(id_module, id_etudiant);
		

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
	
			
		
		return (ArrayList<Notes>) notes;

	}	

}
