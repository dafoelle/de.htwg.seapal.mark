package de.htwg.seapal.mark.views.tui;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Scanner;

import com.google.inject.Inject;

import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;
import de.htwg.util.plugin.Plugin;

public class MarkTUI implements Plugin, IObserver{
	
	private IMarkController controller;

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
		if (line.equalsIgnoreCase("q")) {
			continu = false;
		}
		if (line.equalsIgnoreCase("name")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkName(scanner.next());
		}
		if (line.equalsIgnoreCase("la")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkLatitude(scanner.nextDouble());
		}
		if (line.equalsIgnoreCase("lo")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkLongitude(scanner.nextDouble());
		}
		if (line.equalsIgnoreCase("t")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkType(scanner.next());
		}
		if (line.equalsIgnoreCase("day")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkIsDay(scanner.nextBoolean());
		}
		if (line.equalsIgnoreCase("night")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkIsNight(scanner.nextBoolean());
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
			controller.setMarkColor(color);
		}
		if (line.equalsIgnoreCase("f")) {
			Scanner scanner = new Scanner(System.in);
			controller.setMarkFunction(scanner.next());
		}
		return continu;
	}
	
	public void printTUI() {
		System.out.println("Mark: name - new Name");
		System.out.println("      la - new Latitude");
		System.out.println("      lo - new Longitude");
		System.out.println("      t - new Name");
		System.out.println("      day - new Name");
		System.out.println("      night - new Name");
		System.out.println("      c - new Color");
		System.out.println("      f - new Function");
		
		System.out.println(controller.getString());
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
