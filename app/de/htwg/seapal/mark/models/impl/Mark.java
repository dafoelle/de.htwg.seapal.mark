package de.htwg.seapal.mark.models.impl;

import java.awt.Color;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.htwg.seapal.mark.models.IMark;

@Entity
public class Mark implements IMark{

	@Id 
	private UUID id = null;
	protected String name="n.a.";
	protected double latitude = 0.0;
	protected double longitude = 0.0;
	protected String markType = "n.a.";
	protected Boolean IsDay = false;
	protected Boolean IsNight = false;
	protected Color color = Color.white;
	protected String function = "n.a."; 

	public Mark() {
		this.id = UUID.randomUUID();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getLatitude() {
		return this.latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public double getLongitude() {
		return this.longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String getMarkType() {
		return this.markType;
	}

	@Override
	public void setMarkType(String type) {
		this.markType = type;
	}

	@Override
	public Boolean getIsDay() {
		return this.IsDay;
	}

	@Override
	public void setIsDay(Boolean val) {
		this.IsDay = val;
	}

	@Override
	public Boolean getIsNight() {
		return this.IsNight;
	}

	@Override
	public void setIsNight(Boolean val) {
		this.IsNight = val;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String getFunction() {
		return this.function;
	}

	@Override
	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public UUID getId() {
		return this.id;
	}
}