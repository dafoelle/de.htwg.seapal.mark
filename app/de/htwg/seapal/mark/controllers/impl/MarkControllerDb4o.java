package de.htwg.seapal.mark.controllers.impl;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.htwg.seapal.mark.controllers.AbstractMarkController;
import de.htwg.seapal.mark.controllers.IPersistence;
import de.htwg.seapal.mark.models.IMark;

@Singleton 
public class MarkControllerDb4o extends AbstractMarkController implements IPersistence{
	
	protected ObjectContainer db = null;
	protected String filename = "marks.db4o";
	
	@Inject
	public MarkControllerDb4o(IMark mark) {
		this.mark = mark;
		openDatabase();
	}

	@Override
	public void openDatabase() {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), filename);
	}

	@Override
	public void updateAndStoreDatabase(List<IMark> marks) {
		db.store(marks);
	}

	@Override
	public void closeDatabase() {
		if(db != null)
			db.close();
	}

	@Override
	public List<IMark> getAllMarks() {
		return db.query(IMark.class);
	}

	@Override
	public IMark getMarkByName(String _name) {
		final String searchString = _name;
		return (IMark) db.query(new Predicate<IMark>(){
			public boolean match(IMark mark) {
				return mark.getName().equals(searchString);
			}
		});
	}

	@Override
	public void removeFromDatabase(IMark mark) {
		IMark object = getMarkByName(mark.getName());
		if(object != null)
			db.delete(object);
	}
}
