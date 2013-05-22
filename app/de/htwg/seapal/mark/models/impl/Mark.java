package de.htwg.seapal.mark.models.impl;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonProperty;

import de.htwg.seapal.mark.models.IMark;

@Entity
public class Mark implements IMark{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id = null;
	@Column
	protected String name="n.a.";
	@Column
	protected double latitude = 0.0;
	@Column
	protected double longitude = 0.0;
	@Column
	protected String markType = "n.a.";
	@Column
	protected Boolean IsDay = false;
	@Column
	protected Boolean IsNight = false;
	@Column
	protected String color = "white";
	@Column
	protected String function = "n.a."; 

	public Mark() {
		this.id = UUID.randomUUID();
	}
	
	@Override
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@Override
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	@JsonProperty("latitude")
	public double getLatitude() {
		return this.latitude;
	}

	@Override
	@JsonProperty("latitude")
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	@JsonProperty("longitude")
	public double getLongitude() {
		return this.longitude;
	}

	@Override
	@JsonProperty("longitude")
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	@JsonProperty("markType")
	public String getMarkType() {
		return this.markType;
	}

	@Override
	@JsonProperty("markType")
	public void setMarkType(String type) {
		this.markType = type;
	}

	@Override
	@JsonProperty("isDay")
	public Boolean getIsDay() {
		return this.IsDay;
	}

	@Override
	@JsonProperty("isDay")
	public void setIsDay(Boolean val) {
		this.IsDay = val;
	}

	@Override
	@JsonProperty("isNight")
	public Boolean getIsNight() {
		return this.IsNight;
	}

	@Override
	@JsonProperty("isNight")
	public void setIsNight(Boolean val) {
		this.IsNight = val;
	}

	@Override
	@JsonProperty("color")
	public String getColor() {
		return this.color;
	}

	@Override
	@JsonProperty("color")
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	@JsonProperty("function")
	public String getFunction() {
		return this.function;
	}

	@Override
	@JsonProperty("function")
	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	@JsonProperty("_id")
	public UUID getId() {
		return this.id;
	}
	
	@JsonProperty("_id")
	public void setId(UUID id) {
		this.id = id;
	}
	
	/* for couchDB */
	private String rev_val;
	
	@JsonProperty("_rev")
	public String getRev(){
		return this.rev_val;
	}
	@JsonProperty("_rev")
	public void setRev(String rev){
		this.rev_val = rev;
	}
}