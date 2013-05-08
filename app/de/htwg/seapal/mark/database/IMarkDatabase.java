package de.htwg.seapal.mark.database;

import java.util.List;
import java.util.UUID;

import de.htwg.seapal.mark.models.IMark;

public interface IMarkDatabase {

	UUID newMark();

	void saveMark(IMark boat);

	void deleteMark(UUID id);

	IMark getMark(UUID id);

	List<IMark> getMarks();

	boolean closeDB();
}
