package de.htwg.seapal.mark.models.mock;

import java.util.UUID;

import de.htwg.seapal.mark.models.IMark;


public class Mark implements IMark{
	
	@Override 
	public UUID getId() {
		return UUID.fromString("00000000-0000-0000-0000-000000000000");
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