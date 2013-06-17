package de.htwg.seapal.mark.models;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

public interface IMark extends Serializable {
	
	@JsonProperty("_id")
    String getId();

	@JsonProperty("_id")
    void setId(String id);

    @JsonProperty("_rev")
    String getRevision();
   
    @JsonProperty("_rev")
    void setRevision(String rev);
	
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
	
	String getColor();
	void setColor(String color);
	
	String getFunction();
	void setFunction(String function);
}
