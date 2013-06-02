package de.htwg.seapal.mark.controllers;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.seapal.mark.app.MarkImplModule;
import de.htwg.seapal.mark.models.IMark;
import play.libs.Json;
import play.mvc.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class Application extends Controller {
  
    public static Result index() {
        return ok(de.htwg.seapal.mark.views.html.index.render("Your new application is ready."));
    }
    
    public static Result getMark(String id) {
    	
    	Injector injector = Guice.createInjector(new MarkImplModule());		
		IMarkController controller = injector.getInstance(IMarkController.class);		
		try {
			IMark mark = controller.getMark(UUID.fromString(id));		
			return  ok(Json.toJson(mark));		
		}
		catch (Exception ex) {
			return ok(Json.toJson(ex.getMessage()));
		}
    }
    
	public static Result getAllMarks() {
	    	
	    	Injector injector = Guice.createInjector(new MarkImplModule());		
			IMarkController controller = injector.getInstance(IMarkController.class);		
			try {
				Map<String, String> marks = controller.getMarks();
				ArrayList<IMark> result = new ArrayList<IMark>();
				for (Entry<String, String> mark : marks.entrySet()) {	
					IMark tmp = controller.getMark(UUID.fromString(mark.getKey()));
					result.add(tmp);
				}
				return  ok(Json.toJson(result));		
			}
			catch (Exception ex) {
				return ok(Json.toJson(ex.getMessage()));
			}
	    }
  
}
