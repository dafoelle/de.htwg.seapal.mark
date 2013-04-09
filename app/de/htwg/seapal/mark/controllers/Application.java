package de.htwg.seapal.mark.controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(de.htwg.seapal.mark.views.html.index.render("Your new application is ready."));
    }
  
}
