package de.htwg.seapal.mark.controllers;

import java.util.List;

import de.htwg.seapal.mark.models.IMark;

public interface IPersistence {
	
	void openDatabase();
	void closeDatabase();
	
	void updateAndStoreDatabase(List<IMark> marks);
	void removeFromDatabase(IMark mark);
	
	List<IMark> getAllMarks();
	IMark getMarkByName(String name);

}
