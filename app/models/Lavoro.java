package models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Lavoro extends Model {
	private static final long serialVersionUID = 1L;
	
	@Id
    public Long id;
    public String descrizione;
    public String tipo;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Elaborato> elaborati = new LinkedList<Elaborato>();
    
    public Lavoro() {
    	
    }
    
    public Lavoro(long ID, String tipo, String descrizione){
    	this.id = ID;
    	this.tipo = tipo;
    	this.descrizione = descrizione;
    }
    
    public static Model.Finder<Long, Lavoro> find = new Model.Finder<Long, Lavoro>(
            Long.class, Lavoro.class
    );
}
