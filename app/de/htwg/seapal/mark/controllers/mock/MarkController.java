package de.htwg.seapal.mark.controllers.mock;

import java.util.Map;
import java.util.UUID;

import com.google.inject.Inject;
import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.common.observer.Observable;

public class MarkController extends Observable implements IMarkController {

	protected IMark mark;
	
	@Inject 
	public MarkController(IMark mark) {
		this.mark = mark;
	}

	@Override
	public Map<String, String> getMarks() {
		return null;
	}

	@Override
	public UUID newMark() {
		return mark.getId();
	}

	@Override
	public void deleteMark(UUID id) {
	}

	@Override
	public void closeDB() {
	}

	@Override
	public void setMarkName(UUID id, String string) {
		mark.setName(string);	
		notifyObservers();
	}

	@Override
	public String getMarkName(UUID id) {
		return mark.getName();
	}

	@Override
	public double getMarkLatitude(UUID id) {
		return mark.getLatitude();
	}

	@Override
	public void setMarkLatitude(UUID id, double latitute) {
		mark.setLatitude(latitute);
		notifyObservers();
	}

	@Override
	public double getMarkLongitude(UUID id) {
		return mark.getLongitude();
	}

	@Override
	public void setMarkLongitude(UUID id, double longitude) {
		mark.setLongitude(longitude);
		notifyObservers();		
	}

	@Override
	public String getMarkType(UUID id) {
		return mark.getMarkType();
	}

	@Override
	public void setMarkType(UUID id, String type) {
		mark.setMarkType(type);
		notifyObservers();
	}

	@Override
	public Boolean getMarkIsDay(UUID id) {
		return mark.getIsDay();
	}

	@Override
	public void setMarkIsDay(UUID id, Boolean val) {
		mark.setIsDay(val);
		notifyObservers();
	}

	@Override
	public Boolean getMarkIsNight(UUID id) {
		return mark.getIsNight();
	}

	@Override
	public void setMarkIsNight(UUID id, Boolean val) {
		mark.setIsNight(val);
		notifyObservers();
	}

	@Override
	public String getMarkColor(UUID id) {
		return mark.getColor();
	}

	@Override
	public void setMarkColor(UUID id, String color) {
		mark.setColor(color);
		notifyObservers();
	}

	@Override
	public String getMarkFunction(UUID id) {
		return mark.getFunction();
	}

	@Override
	public void setMarkFunction(UUID id, String function) {
		mark.setFunction(function);
		notifyObservers();
	}

	@Override
	public String getString(UUID id) {
		return  "Mark: " + mark.getName() + "\n" + 
				"Latitude: " + mark.getLatitude() + "\n" +
				"Longitude: " + mark.getLongitude() + "\n" +
				"Type: " + mark.getMarkType() + "\n" +
				"Day: "  + mark.getIsDay() + "\n" +
				"Night: "+ mark.getIsNight() + "\n" +
				"Color: "+ mark.getColor().toString() + "\n" +
				"Function: "+ mark.getFunction();	
	}
	

}