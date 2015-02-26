package controllers;

import models.Attivita;
import models.Tecnico;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	return redirect(routes.Activities.list());
    }

}
