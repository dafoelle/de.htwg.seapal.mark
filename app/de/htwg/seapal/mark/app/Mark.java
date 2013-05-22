package de.htwg.seapal.mark.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import play.api.Application;
import play.api.DefaultApplication;
import play.api.Mode;
import play.api.Play;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.seapal.mark.views.tui.MarkTUI;
	

public class Mark {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		Application play = new DefaultApplication(new File("."),
				Mark.class.getClassLoader(), null, Mode.Dev());

		Play.start(play);
		
		try {
			// Set up Google Guice Dependency Injector
			Injector injector = Guice.createInjector(new MarkImplModule());
			
			IMarkController controller = injector.getInstance(IMarkController.class);
		/*	
			//RMI-Server Registry Registration
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			
			Registry registry = LocateRegistry.getRegistry();
			System.out.println("Registry connected.");
			
			IMarkController stub = (IMarkController)UnicastRemoteObject.exportObject(controller, 0);
			System.out.println("Object exported.");
			
			registry.rebind("Seapal_Mark", stub);
			System.out.println("Object bound to Registry.");
		*/
			MarkTUI tui = new MarkTUI(controller);
			
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			do {
				tui.printTUI();
				System.out.printf("%n> ");
			}
			while (tui.processInputLine(br.readLine())) ;
			
			System.out.println("exit.");
			
		} finally {
			Play.stop();
		}
	}

}
