package de.htwg.seapal.mark.controllers.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.inject.Inject;

import de.htwg.seapal.common.observer.Observable;
import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.seapal.mark.database.IMarkDatabase;
import de.htwg.seapal.mark.models.IMark;

public class MarkController extends Observable implements IMarkController {

	protected IMarkDatabase db;
	
	@Inject 
	public MarkController(IMarkDatabase db) throws RemoteException {
		this.db = db;
	}

	@Override
	public Map<String, String> getMarks() throws RemoteException {
		List<IMark> query = db.getMarks();
		Map<String, String> map = new HashMap<String, String>();
		for (IMark mark : query) {
			map.put(mark.getId().toString(), mark.getName());
		}
		return map;
	}

	@Override
	public UUID newMark() throws RemoteException {
		return db.newMark();
	}

	@Override
	public void deleteMark(UUID id) throws RemoteException {
		db.deleteMark(id);
		notifyObservers();
	}

	@Override
	public void closeDB() throws RemoteException {
		db.closeDB();
	}

	@Override
	public void setMarkName(UUID id, String string) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setName(string);
		db.saveMark(mark);
		notifyObservers();		
	}

	@Override
	public String getMarkName(UUID id) throws RemoteException {
		return db.getMark(id).getName();
	}

	@Override
	public double getMarkLatitude(UUID id) throws RemoteException {
		return db.getMark(id).getLatitude();
	}

	@Override
	public void setMarkLatitude(UUID id, double latitute) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setLatitude(latitute);
		db.saveMark(mark);
		notifyObservers();
	}

	@Override
	public double getMarkLongitude(UUID id) throws RemoteException {
		return db.getMark(id).getLongitude();
	}

	@Override
	public void setMarkLongitude(UUID id, double longitude) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setLongitude(longitude);
		db.saveMark(mark);
		notifyObservers();		
	}

	@Override
	public String getMarkType(UUID id) throws RemoteException {
		return db.getMark(id).getMarkType();
	}

	@Override
	public void setMarkType(UUID id, String type) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setMarkType(type);
		db.saveMark(mark);
		notifyObservers();
	}

	@Override
	public Boolean getMarkIsDay(UUID id) throws RemoteException {
		return db.getMark(id).getIsDay();
	}

	@Override
	public void setMarkIsDay(UUID id, Boolean val) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setIsDay(val);
		db.saveMark(mark);
		notifyObservers();
	}
	
	@Override
	public IMark getMark(UUID id) {
		return db.getMark(id);
	}
	
	@Override
	public Boolean getMarkIsNight(UUID id) throws RemoteException {
		return db.getMark(id).getIsNight();
	}

	@Override
	public void setMarkIsNight(UUID id, Boolean val) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setIsNight(val);
		db.saveMark(mark);
		notifyObservers();
	}

	@Override
	public String getMarkColor(UUID id) throws RemoteException {
		return db.getMark(id).getColor();
	}

	@Override
	public void setMarkColor(UUID id, String color) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setColor(color);
		db.saveMark(mark);
		notifyObservers();
	}

	@Override
	public String getMarkFunction(UUID id) throws RemoteException {
		return db.getMark(id).getFunction();
	}

	@Override
	public void setMarkFunction(UUID id, String function) throws RemoteException {
		IMark mark = db.getMark(id);
		mark.setFunction(function);
		db.saveMark(mark);
		notifyObservers();
	}

	@Override
	public String getString(UUID id) throws RemoteException {
		IMark mark = db.getMark(id);
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
