package de.htwg.seapal.mark.database.impl;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.ektorp.*;
import org.ektorp.ViewResult.Row;
import org.ektorp.impl.*;
import org.ektorp.http.*;

import de.htwg.seapal.mark.database.IMarkDatabase;
import de.htwg.seapal.mark.models.IMark;
import de.htwg.seapal.mark.models.impl.Mark;

public class MarkCouchDatabase implements IMarkDatabase {

	private CouchDbConnector db;
	
	public MarkCouchDatabase() {
		HttpClient client = null;
		try {
			client = new StdHttpClient.Builder()
			.url("http://lenny2.in.htwg-konstanz.de:5984")
			.build();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		CouchDbInstance dbInstance = new StdCouchDbInstance(client);
		db = dbInstance.createConnector("mark_db", true);
	}
	
	@Override
	public String newMark() {
		Mark mark = new Mark();
		try {
			db.create(mark.getId().toString(),mark);
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		return mark.getId();
	}

	@Override
	public void saveMark(IMark mark) {
		try {
			db.update((Mark)mark);
		} catch (Exception e) {
			//TODO: Always error thrown here.
			return;
		}
	}

	@Override
	public void deleteMark(UUID id) {
		try {
			db.delete(getMark(id));
		} catch (Exception e) {
			//TODO: Always error thrown here.
			return;
		}
	}

	@Override
	public IMark getMark(UUID id) {
		Mark mark;
		try {
			mark = db.get(Mark.class, id.toString());
		} catch (Exception e) {
			return null;
		}
		return mark;
	}

	@Override
	public List<IMark> getMarks() {
		List<IMark> lst = new LinkedList<IMark>();
		ViewQuery query = new ViewQuery().allDocs();		
		ViewResult vr = db.queryView(query);
		
	
		for(Row r : vr.getRows()) {
			lst.add(getMark(UUID.fromString(r.getId())));
		}
		return lst;
	}

	@Override
	public boolean closeDB() {		
		return true;
	}

}
