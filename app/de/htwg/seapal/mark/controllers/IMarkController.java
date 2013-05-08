package de.htwg.seapal.mark.controllers;

import java.awt.Color;
import java.util.Map;
import java.util.UUID;

import de.htwg.seapal.common.observer.IObservable;

public interface IMarkController extends IObservable{

	Map<String,String> getMarks();
	
	UUID newMark();
	void deleteMark(UUID id);
	void closeDB();
	
	void setMarkName(UUID id, String string);	
	String getMarkName(UUID id);

	double getMarkLatitude(UUID id);
	void setMarkLatitude(UUID id, double latitute);

	double getMarkLongitude(UUID id);
	void setMarkLongitude(UUID id, double longitude);

	String getMarkType(UUID id);
	void setMarkType(UUID id, String type);

	Boolean getMarkIsDay(UUID id);
	void setMarkIsDay(UUID id, Boolean val);
	
	Boolean getMarkIsNight(UUID id);
	void setMarkIsNight(UUID id, Boolean val);
	
	Color getMarkColor(UUID id);
	void setMarkColor(UUID id, Color color);
	
	String getMarkFunction(UUID id);
	void setMarkFunction(UUID id, String function);
	
	String getString(UUID id);

}