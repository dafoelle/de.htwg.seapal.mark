package de.htwg.seapal.mark.views.tui;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import com.google.inject.Inject;

import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.seapal.common.observer.Event;
import de.htwg.seapal.common.observer.IObserver;
import de.htwg.seapal.common.plugin.Plugin;

public class MarkTUI implements Plugin, IObserver{
	
	private IMarkController controller;
	private String selectedMark = null;

	@Inject
	public MarkTUI(IMarkController controller) {
		this.controller = controller;
		controller.addObserver(this);
	}

	public void update(Event e) {
		printTUI();
	}

	public boolean processInputLine(String line) {
		
		boolean continu = true;
		
		if(line.equalsIgnoreCase("show")) {
			printMarks();
		}		
		if(line.equalsIgnoreCase("select")) {
			Scanner scanner = new Scanner(System.in);
			selectedMark = scanner.next();
		}			
		if(line.equalsIgnoreCase("new")) {
			UUID mark = controller.newMark();
			selectedMark = mark.toString();
		}		
		if (line.equalsIgnoreCase("quit")) {
			continu = false;
			controller.closeDB();
		}
		
		if(selectedMark != null)
			handleMarkSpecificEvents(line);
		
		return continu;
	}
	
	private void handleMarkSpecificEvents(String line) {
		if(line.equalsIgnoreCase("release")) {
			selectedMark = null;
		}		
		if(line.equalsIgnoreCase("delete")) {
			Scanner scanner = new Scanner(System.in);
			controller.deleteMark(UUID.fromString(scanner.next()));
		}
		if (line.equalsIgnoreCase("name")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkName(UUID.fromString(selectedMark), scanner.next());
		}
		if (line.equalsIgnoreCase("la")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkLatitude(UUID.fromString(selectedMark), scanner.nextDouble());
		}
		if (line.equalsIgnoreCase("lo")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkLongitude(UUID.fromString(selectedMark), scanner.nextDouble());
		}
		if (line.equalsIgnoreCase("t")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkType(UUID.fromString(selectedMark), scanner.next());
		}
		if (line.equalsIgnoreCase("day")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkIsDay(UUID.fromString(selectedMark), scanner.nextBoolean());
		}
		if (line.equalsIgnoreCase("night")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkIsNight(UUID.fromString(selectedMark), scanner.nextBoolean());
		}
		if (line.equalsIgnoreCase("c")) {
			Scanner scanner = new Scanner(System.in);
			Color color;
			try {
			    Field field = Class.forName("java.awt.Color").getField(scanner.next());
			    color = (Color)field.get(null);
			} catch (Exception e) {
			    color = Color.white;
			}
			controller.setMarkColor(UUID.fromString(selectedMark), color);
		}
		if (line.equalsIgnoreCase("f")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkFunction(UUID.fromString(selectedMark), scanner.next());
		}
	}

	private void printMarks() {
		System.out.println("Marks:");
		for(Entry<String, String> x : controller.getMarks().entrySet()) {
			System.out.println(x.getKey() + ": " + x.getValue());
		}		
	}

	public void printTUI() {
		
		if(selectedMark != null) {
			System.out.println("Mark: name - new Name");
			System.out.println("      la - new Latitude");
			System.out.println("      lo - new Longitude");
			System.out.println("      t - new Name");
			System.out.println("      day - new Name");
			System.out.println("      night - new Name");
			System.out.println("      c - new Color");
			System.out.println("      f - new Function");
			System.out.println("      delete - remove selected Mark");
			System.out.println("      release - release selected Mark");
			
			System.out.println(controller.getString(UUID.fromString(selectedMark)));
		}
		else {
			System.out.println("Options: show - show all Marks");
			System.out.println("         select - select Mark");			
			System.out.println("         new - create new Mark");
			System.out.println("         quit - quit Application");
		}
			
	}

	@Override
	public String getMenuEntry() {
		return "Mark";
	}
	
	@Override
	public char getMenuKey() {
		return 'k';
	}
}
