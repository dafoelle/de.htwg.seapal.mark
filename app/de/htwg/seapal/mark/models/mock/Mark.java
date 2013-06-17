package de.htwg.seapal.mark.models.mock;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonProperty;

import de.htwg.seapal.mark.models.IMark;


public class Mark implements IMark{
	
	@Id 
	@GeneratedValue
	private String id;
	private String rev;
	
	@Override
	@JsonProperty("_id")
	public String getId() {
		return this.id;
	}

	@Override
	@JsonProperty("_id")
	public void setId(String id) {
		this.id = id;
	}

	@Override
	@JsonProperty("_rev")
	public String getRevision() {
		return this.rev;
	}

	@Override
	@JsonProperty("_rev")
	public void setRevision(String rev) {
		this.rev = rev;
	}
	
	@Override
	public String getName() {
		return "testMark";
	}

	@Override
	public void setName(String name) {
	}

	@Override
	public double getLatitude() {
		return 5.0;
	}

	@Override
	public void setLatitude(double latitude) {
	}

	@Override
	public double getLongitude() {
		return 6.0;
	}

	@Override
	public void setLongitude(double longitude) {
	}

	@Override
	public String getMarkType() {
		return "TestMarkType";
	}

	@Override
	public void setMarkType(String type) {
	}

	@Override
	public Boolean getIsDay() {
		return false;
	}

	@Override
	public void setIsDay(Boolean val) {
	}

	@Override
	public Boolean getIsNight() {
		return false;
	}

	@Override
	public void setIsNight(Boolean val) {
	}

	@Override
	public String getColor() {
		return "black";
	}

	@Override
	public void setColor(String color) {
	}

	@Override
	public String getFunction() {
		return "TestFunction";
	}

	@Override
	public void setFunction(String function) {
	}

	

}