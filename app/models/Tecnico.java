package models;

import play.db.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Model {
    @Id
    public String email;
    public String nome;
    public String password;
    String firma;
    String via;
    String provincia;
    String CF;
    String PI;
    String tel;
    String fax;
    String banca;
    String filiale;
    String iban;
    int contrInps;
    int contrCassa;
    int iva;
    int numIscrizione;
    String collegio;
    String cell;
    String pec;
    @OneToMany
    public List<Attivita> lavori;

    public Tecnico(String email, String nome, String password) {
        this.email = email;
        this.nome = nome;
        this.password = password;
    }

    public static Finder<String, Tecnico> find = new Finder<String, Tecnico>(
            String.class, Tecnico.class
    );

    public static Tecnico authenticate(String email, String password) {
        return find.where().eq("email", email)
                .eq("password", password).findUnique();
    }
}
