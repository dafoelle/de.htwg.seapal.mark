package de.htwg.seapal.mark.app;

import com.google.inject.AbstractModule;

import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.seapal.mark.database.IMarkDatabase;
import de.htwg.seapal.mark.models.IMark;

public class MarkImplModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMark.class).to(de.htwg.seapal.mark.models.impl.Mark.class);
		bind(IMarkController.class).to(de.htwg.seapal.mark.controllers.impl.MarkController.class);	
		bind(IMarkDatabase.class).to(de.htwg.seapal.mark.database.impl.MarkCouchDatabase.class);
		//bind(IMarkDatabase.class).to(de.htwg.seapal.mark.database.impl.MarkEbeanDatabase.class);
		//bind(IMarkDatabase.class).to(de.htwg.seapal.mark.database.impl.MarkDb4oDatabase.class);
	}

}