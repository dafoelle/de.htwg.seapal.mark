package de.htwg.seapal.mark.controllers;

import java.awt.Color;

import de.htwg.util.observer.IObservable;

public interface IMarkController extends IObservable{

	void setMarkName(String string);	
	String getMarkName();

	double getMarkLatitude();
	void setMarkLatitude(double latitute);

	double getMarkLongitude();
	void setMarkLongitude(double longitude);

	String getMarkType();
	void setMarkType(String type);

	Boolean getMarkIsDay();
	void setMarkIsDay(Boolean val);
	
	Boolean getMarkIsNight();
	void setMarkIsNight(Boolean val);
	
	Color getMarkColor();
	void setMarkColor(Color color);
	
	String getMarkFunktion();
	void setMarkFunction(String function);
	
	String getString();

}