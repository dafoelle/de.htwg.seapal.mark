package de.htwg.seapal.mark.app;

import com.google.inject.AbstractModule;

import de.htwg.seapal.mark.controllers.IMarkController;
import de.htwg.seapal.mark.models.IMark;

public class MarkMockModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMark.class).to(de.htwg.seapal.mark.models.mock.Mark.class);
		bind(IMarkController.class).to(de.htwg.seapal.mark.controllers.mock.MarkController.class);			
	}

}
