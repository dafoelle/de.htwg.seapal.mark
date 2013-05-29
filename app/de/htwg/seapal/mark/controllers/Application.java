package de.htwg.seapal.mark.controllers;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.seapal.mark.app.MarkImplModule;
import de.htwg.seapal.mark.models.IMark;
import play.api.libs.json.Writes;
import play.libs.Json;
import play.mvc.*;
import java.util.UUID;

public class Application extends Controller {
  
    public static Result index() {
        return ok(de.htwg.seapal.mark.views.html.index.render("Your new application is ready."));
    }
    
    public static void getMark(String id) {
    	
    	Injector injector = Guice.createInjector(new MarkImplModule());		
		IMarkController controller = injector.getInstance(IMarkController.class);
		
		IMark mark = controller.getMark(UUID.fromString(id));
		
		//de.htwg.seapal.mark.views..json.mark.render(mark);
		
		//response().setContentType("application/json");
		//return ok(new Gson().toJson(mark));
    }
  
}
