package de.htwg.seapal.mark.controllers;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.UUID;

import de.htwg.seapal.common.observer.IObservable;
import de.htwg.seapal.mark.models.IMark;

public interface IMarkController extends /*IObservable,*/ IHelperRemote {

	Map<String,String> getMarks() throws RemoteException;
	
	String newMark() throws RemoteException;
	void deleteMark(UUID id) throws RemoteException;
	void closeDB() throws RemoteException;
	
	void setMarkName(UUID id, String string)throws RemoteException;	
	String getMarkName(UUID id) throws RemoteException;

	double getMarkLatitude(UUID id) throws RemoteException;
	void setMarkLatitude(UUID id, double latitute) throws RemoteException;

	double getMarkLongitude(UUID id) throws RemoteException;
	void setMarkLongitude(UUID id, double longitude) throws RemoteException;

	String getMarkType(UUID id) throws RemoteException;
	void setMarkType(UUID id, String type) throws RemoteException;

	Boolean getMarkIsDay(UUID id) throws RemoteException;
	void setMarkIsDay(UUID id, Boolean val) throws RemoteException;
	
	Boolean getMarkIsNight(UUID id) throws RemoteException;
	void setMarkIsNight(UUID id, Boolean val) throws RemoteException;
	
	String getMarkColor(UUID id) throws RemoteException;
	void setMarkColor(UUID id, String color) throws RemoteException;
	
	String getMarkFunction(UUID id) throws RemoteException;
	void setMarkFunction(UUID id, String function) throws RemoteException;
	
	String getString(UUID id) throws RemoteException;

	IMark getMark(UUID id) throws RemoteException;

}