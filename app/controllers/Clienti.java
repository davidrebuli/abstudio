package controllers;

import java.util.List;

import models.Cliente;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.clienti.*;

public class Clienti extends Controller{
	private static final Form<Cliente> clienteForm = Form.form(Cliente.class);
	
	  public static Result list() {
		    List<Cliente> clienti = Cliente.findAll();
		    return ok(list.render(clienti));
		  }
	  
	  public static Result save() {
		  Form<Cliente> boundForm = clienteForm.bindFromRequest();
		  if(boundForm.hasErrors()) {
			  flash("error", "Please correct the form below.");
			  return badRequest(details.render(boundForm));
		  }

		  Cliente cliente = boundForm.get();
		  cliente.save();
		  flash("success",
				  String.format("Successfully added product %s", cliente));

		  return redirect(routes.Clienti.list());
	  }
	  
	  public static Result details(String nome) {
		  final Cliente cliente = Cliente.findByName(nome);
		  if (cliente == null) {
			  return notFound(String.format("Il cliente %s non esiste.", nome));
		  }

		  Form<Cliente> filledForm = clienteForm.fill(cliente);
		  return ok(details.render(filledForm));
	  }
}
