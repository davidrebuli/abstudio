package models;


import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cliente extends Model {
	
	private static List<Cliente> clienti;
	
    @Id
    @Constraints.Required
    public String codiceFiscale;
    public int codice;
    @Constraints.Required
    public String nome;
    public String cognome;
    public String luogoNascita;
    public String dataNascita;
    public Character sesso;

    public String indirizzo;
    public String comune;
    public String provincia;
    public String CAP;
    public String telefono;
    public boolean ritenuta;
    public String cartellina;
    @OneToMany
    List<Attivita> attivita;

    public Cliente(String nome, String cognome, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    public static Finder<String, Cliente> find = new Finder<String, Cliente>(
            String.class, Cliente.class
    );
    
    public static List<Cliente> findAll() {
    	return find.all();
    }
    
    public static Cliente findByName(String nome) {
    	return find.where().eq("nome", nome).findUnique();
    }
}
