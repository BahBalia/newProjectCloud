package models;

import play.db.jpa.Model;
import play.*;
import play.data.validation.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tache extends Model {
	public String libelle;
	public Boolean statut;
	public String description;


}
