package models;

import com.avaje.ebean.Ebean;
import org.junit.Test;
import play.libs.Yaml;
import play.test.WithApplication;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by david on 03/01/15.
 */
public class ModelsTest extends WithApplication {
    @Test
    public void createAndRetrieveUser() {
        new Cliente("toni", "bruno", "ser4534rtse4rs4").save();
        Cliente toni = Cliente.find.where().eq("nome", "toni").findUnique();
        assertNotNull(toni);
        assertEquals("toni", toni.nome);
    }

    @Test
    public void tryAuthenticateUser() {
        //new Tecnico("bob@gmail.com", "Bob", "secret").save();
        //Ebean.save((List) Yaml.load("test-data.yml"));
        assertNotNull(Tecnico.authenticate("bob@gmail.com", "secret"));
        assertNull(Tecnico.authenticate("bob@gmail.com", "badpassword"));
        assertNull(Tecnico.authenticate("tom@gmail.com", "secret"));
        //assertNotNull(Tecnico.authenticate("pat@gmail.com", "secret2"));
        //assertNull(Tecnico.authenticate("pat@gmail.com", "badpassword"));
        //assertNull(Tecnico.authenticate("tom@gmail.com", "secret"));
    }

    @Test
    public void findAttivitaCliente(){
        //new Cliente("paolo","verdi","123456789").save();
        //new Cliente("luca","bianchi","987654321").save();
        Cliente cliente1 = Cliente.find.where().eq("nome","mario").findUnique();
        Cliente cliente2 = Cliente.find.where().eq("nome","luigi").findUnique();


        assertNotNull(cliente1);
        assertNotNull(cliente2);
    }

}
