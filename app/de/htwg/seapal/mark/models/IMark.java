package de.htwg.seapal.mark.models;

import java.awt.Color;
import java.util.UUID;

public interface IMark {
	
	UUID getId();
	
	String getName();
	void setName(String name);

	double getLatitude();
	void setLatitude(double latitute);

	double getLongitude();
	void setLongitude(double longitude);

	String getMarkType();
	void setMarkType(String type);

	Boolean getIsDay();
	void setIsDay(Boolean val);
	
	Boolean getIsNight();
	void setIsNight(Boolean val);
	
	Color getColor();
	void setColor(Color color);
	
	String getFunction();
	void setFunction(String function);
}
