package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Installatore extends Model {
    @Id
    int ID;
    String ragione_sociale;
    String partita_iva;
    String indirizzo;
    String comune;
    String provincia;
    int CAP;
    String legale_rapp;
    String CF;
    String luogoNascita;
    String dataNascita;
    @OneToMany
    List<Attivita> attivita;
}
