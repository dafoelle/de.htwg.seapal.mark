package de.htwg.seapal.mark.controllers;

import java.awt.Color;

import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.util.observer.Observable;

public abstract class AbstractMarkController extends Observable implements IMarkController {
	
	protected IMark mark;

	@Override
	public void setMarkName(String string) {
		mark.setName(string);
		notifyObservers();
	}
	
	@Override
	public String getMarkName() {
		return mark.getName();
	}

	@Override
	public double getMarkLatitude() {
		return mark.getLatitude();
	}

	@Override
	public void setMarkLatitude(double latitute) {
		mark.setLatitude(latitute);
		notifyObservers();		
	}

	@Override
	public double getMarkLongitude() {
		return mark.getLongitude();
	}

	@Override
	public void setMarkLongitude(double longitude) {
		mark.setLongitude(longitude);
		notifyObservers();
	}

	@Override
	public String getMarkType() {
		return mark.getMarkType();
	}

	@Override
	public void setMarkType(String type) {
		mark.setMarkType(type);
		notifyObservers();
	}

	@Override
	public Boolean getMarkIsDay() {
		return mark.getIsDay();
	}

	@Override
	public void setMarkIsDay(Boolean val) {
		mark.setIsDay(val);
		notifyObservers();
	}

	@Override
	public Boolean getMarkIsNight() {
		return mark.getIsNight();
	}

	@Override
	public void setMarkIsNight(Boolean val) {
		mark.setIsNight(val);
		notifyObservers();
	}

	@Override
	public Color getMarkColor() {
		return mark.getColor();
	}

	@Override
	public void setMarkColor(Color color) {
		mark.setColor(color);
		notifyObservers();
	}

	@Override
	public String getMarkFunktion() {
		return mark.getFunktion();
	}

	@Override
	public void setMarkFunction(String function) {
		mark.setFunction(function);
		notifyObservers();
	}
	
	@Override
	public String getString() {
		return  "Mark: " + mark.getName() + "\n" + 
				"Latitude: " + mark.getLatitude() + "\n" +
				"Longitude: " + mark.getLongitude() + "\n" +
				"Type: " + mark.getMarkType() + "\n" +
				"Day: "  + mark.getIsDay() + "\n" +
				"Night: "+ mark.getIsNight() + "\n" +
				"Color: "+ mark.getColor().toString() + "\n" +
				"Function: "+ mark.getFunktion();				
	}

}
