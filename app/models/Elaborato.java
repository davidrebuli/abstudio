package models;
import java.util.Collection;
import java.util.List;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Elaborato extends Model {
    @Id
    private long ID;
    public String codice;
    public String descrizione;  
    
    @ManyToMany(mappedBy = "elaborati")
    public List<Lavoro> lavori;
    
    public Elaborato(){
    	
    }
    
    public Elaborato(String codice, String descrizione){
    	this.codice = codice;
    	this.descrizione = descrizione;
    }
}
