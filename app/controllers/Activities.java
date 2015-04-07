package controllers;

import java.util.List;

import models.Attivita;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.activities.*;



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
			  return badRequest(details.render(boundForm));
		  }

		  Attivita attivita = boundForm.get();
		  attivita.save();
		  flash("success",
				  String.format("Successfully added product %s", attivita));

		  return redirect(routes.Activities.list());
	  }
	  
	  public static Result newActivity() {
		  return ok(details.render(activityForm));
	  }
	  
	  public static Result details(Attivita attivita) {

		  Form<Attivita> filledForm = activityForm.fill(attivita);
		  return ok(details.render(filledForm));
	  }
}
