package controllers;

import play.mvc.Controller;
import java.util.*;
import models.Tache;
import play.data.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Application extends Controller {

	// Affiche toutes les tâches (voir variable taches) dans le template views/listTache.html
    public static void listTache() {
        List<Tache> taches = Tache.findAll();
	render(taches);
    }

    // Affiche le template views/ajouterTacheForm.html (formulaire d'ajout d'une tâche)
    public static void ajouterTacheForm() {
        render();
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public static void ajouterTache(String libelle, Boolean statut, String description) {
        Tache tache = new Tache();
	tache.libelle = libelle;
	if(statut != null)
		tache.statut = true;
	else
		tache.statut = false;	
	tache.description = description;
	tache.save();
	render();
	
    }

    // Change le statut d'une tâche en base de données
    public static void validerTache(Long id) {
    	Tache t = Tache.findById(id);
	t.statut = true;
	t.save();
	render();
    }

    // Supprime une tâche en base de données
    public static void supprimerTache(Long id) {
       Tache t = Tache.findById(id);
	System.out.println("id:" + id);
	t.delete();
    }

    // Modifie une tâche en base de données
    public static void editTache(Long id, String title) {
        Tache t = Tache.findById(id);
	t.libelle = title;
	t.save();
	renderJSON(t);
    }
}
