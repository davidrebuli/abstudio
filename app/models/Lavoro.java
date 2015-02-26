package models;

import java.util.LinkedList;
import java.util.List;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import javax.persistence.*;

@Entity
public class Lavoro extends Model {
    @Id
    public long ID;
    public String descrizione;
    public String tipo;

    @ManyToMany(cascade = CascadeType.ALL)
    public List<Elaborato> elaborati = new LinkedList<Elaborato>();
    
    public Lavoro() {
    	
    }
    
    public Lavoro(String tipo, String descrizione){
    	this.tipo = tipo;
    	this.descrizione = descrizione;
    }
    
    public static Finder<String, Lavoro> find = new Finder<String, Lavoro>(
            String.class, Lavoro.class
    );
}
