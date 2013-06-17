package de.htwg.seapal.mark.database.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.avaje.ebean.Ebean;

import de.htwg.seapal.mark.database.IMarkDatabase;
import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.mark.models.mock.Mark;

public class MarkEbeanDatabase implements IMarkDatabase {

	@Override
	public String newMark() {
		Mark mark = new Mark();
		Ebean.save(mark);
		return mark.getId();
	}

	@Override
	public void saveMark(IMark mark) {
		Ebean.save(mark);
	}

	@Override
	public void deleteMark(UUID id) {
		Ebean.delete(Mark.class, id);

	}

	@Override
	public IMark getMark(UUID id) {
		IMark mark = Ebean.find(Mark.class, id);
		if (mark == null)
			throw new NoSuchElementException("No Boat for id : " + id);
		return mark;
	}

	@Override
	public List<IMark> getMarks() {
		List<Mark> findList = Ebean.find(Mark.class).findList();
		List<IMark> list = new ArrayList<IMark>();
		list.addAll(findList);
		return list;		
	}

	@Override
	public boolean closeDB() {
		return true;
	}

}
