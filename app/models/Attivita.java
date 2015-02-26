package models;

import play.db.ebean.Model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Attivita extends Model {
	
	private static List<Attivita> activities;
	
	  /*static {
		  activities = new ArrayList<Attivita>();
		  Cliente cliente = new Cliente("asdf","sdf","sde");
		  Elaborato elaborato = new Elaborato("A","RELAZIONE ex L.10");
		  Lavoro lavoro = new Lavoro("55% CON AQE", "Ampiamento eidficio residenziale");
		  activities.add(new Attivita("1111111111111", cliente, lavoro));
		  activities.add(new Attivita("2222222222222", cliente, lavoro));
		  activities.add(new Attivita("3333333333333", cliente, lavoro));
		  activities.add(new Attivita("4444444444444", cliente, lavoro));
		  activities.add(new Attivita("5555555555555", cliente, lavoro));
		  }*/
	  
    @Id
    public Long id;
    public String codice;
    public String nome;

    @ManyToOne
    public Installatore installatore;
    @ManyToOne
    public Cliente cliente;
    @ManyToOne
    public Tecnico tecnico;
    @ManyToOne
    public Lavoro lavoro;

    int avanzamento;

    public String indirizzo;
    public String comune;
    public String provincia;
    public String CAP;
    public int foglio;
    public String mappale;

    public Attivita(){
    }
    
    public Attivita(String codice, Cliente cliente, Lavoro lavoro){
    	this.codice = codice;
        this.cliente = cliente;
        this.lavoro = lavoro;
    }

    public static Model.Finder<Long,Attivita> find = new Model.Finder(Long.class, Attivita.class);

    public static Attivita create(String codice, Cliente cliente, Lavoro lavoro){
        Attivita attivita = new Attivita(codice, cliente, lavoro);
        attivita.save();
        return attivita;
    }
    
    public static List<Attivita> findAll() {
    	return find.all();
    }

    public static Attivita findByEan(String codice) {
    	return find.where().eq("codice", codice).findUnique();
    }
}
