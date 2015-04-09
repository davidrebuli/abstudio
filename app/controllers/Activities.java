package controllers;

import java.util.List;

import models.Attivita;
import models.Cliente;
import models.Lavoro;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.activities.details;
import views.html.activities.list;



public class Activities extends Controller {
	private static final Form<Attivita> activityForm = Form.form(Attivita.class);

	  public static Result list() {
	    List<Attivita> activities = Attivita.findAll();
	    return ok(list.render(activities));
	  }
	  
	  public static Result save() {
		  Form<Attivita> boundForm = activityForm.bindFromRequest();
		  if(boundForm.hasErrors()) {
			  flash("error", "Please correct the form below.");
			  return badRequest(details(boundForm));
		  }

		  Attivita attivita = boundForm.get();
		  
		  Logger.debug(Json.toJson(attivita).toString());
		  attivita.save();
		  flash("success",
				  String.format("Successfully added product %s", attivita));

		  return redirect(routes.Activities.list());
	  }

	  public static Result newActivity() {
		  return ok(details(activityForm));
	  }
	  
	  public static Result details(Attivita attivita) {

		  Form<Attivita> filledForm = activityForm.fill(attivita);
		  return ok(details(filledForm));
	  }

	  
	  private static Html details(Form<Attivita> boundForm) {
		  return details.render(boundForm);
	  }	  

}
