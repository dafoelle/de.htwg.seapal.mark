package de.htwg.seapal.mark.controllers.impl;

import com.db4o.ObjectContainer;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.htwg.seapal.mark.controllers.AbstractMarkController;
import de.htwg.seapal.mark.models.impl.Mark;

@Singleton 
public class MarkController extends AbstractMarkController{
	
	protected ObjectContainer db = null;
	protected String filename = "marks.db4o";
	
	@Inject
	public MarkController(Mark mark) {
		this.mark = mark;
	}
}
