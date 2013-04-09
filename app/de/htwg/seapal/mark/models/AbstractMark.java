package de.htwg.seapal.mark.models;

import java.awt.Color;

import de.htwg.seapal.mark.models.IMark;

public abstract class AbstractMark implements IMark {

	protected String name="n.a.";
	protected double latitude = 0.0;
	protected double longitude = 0.0;
	protected String markType = "n.a.";
	protected Boolean isDay = false;
	protected Boolean isNight = false;
	protected Color color = Color.white;
	protected String function = "n.a."; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getMarkType() {
		return this.markType;
	}

	public void setMarkType(String type) {
		this.markType = type;
	}

	public Boolean getIsDay() {
		return this.isDay;
	}

	public void setIsDay(Boolean val) {
		this.isDay = val;
	}

	public Boolean getIsNight() {
		return this.isNight;
	}

	public void setIsNight(Boolean val) {
		this.isNight = val;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getFunktion() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
}
