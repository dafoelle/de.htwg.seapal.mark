package de.htwg.seapal.mark.database.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

import de.htwg.seapal.mark.database.IMarkDatabase;
import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.mark.models.impl.Mark;

public class MarkDb4oDatabase implements IMarkDatabase {

	private ObjectContainer db;

	public MarkDb4oDatabase() {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "mark.db");
	}

	@Override
	public String newMark() {
		IMark mark = new Mark();
		saveMark(mark);
		return mark.getId();
	}

	@Override
	public void saveMark(IMark mark) {
		db.store(mark);
	}

	@Override
	public void deleteMark(UUID id) {
		db.delete(getMark(id));
	}

	@Override
	public IMark getMark(final UUID id) {
		@SuppressWarnings("serial")
		List<IMark> query = db.query(new Predicate<IMark>() {
			@Override
			public boolean match(IMark mark) {
				return mark.getId().equals(id);
			}
		});
		if (query.isEmpty())
			throw new NoSuchElementException("No Mark for id : " + id);
		IMark boat = query.get(0);
		return boat;
	}

	@Override
	public List<IMark> getMarks() {
		return db.query(IMark.class);
	}

	@Override
	public boolean closeDB() {
		return db.close();
	}
}
