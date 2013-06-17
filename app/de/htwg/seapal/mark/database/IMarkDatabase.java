package de.htwg.seapal.mark.database;

import java.util.List;
import java.util.UUID;

import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.mark.models.impl.Mark;

public interface IMarkDatabase {

	String newMark();

	void saveMark(IMark mark);

	void deleteMark(UUID id);

	IMark getMark(UUID id);

	List<IMark> getMarks();

	boolean closeDB();
}
