package de.htwg.seapal.mark.controllers.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.htwg.seapal.mark.controllers.AbstractMarkController;
import de.htwg.seapal.mark.models.IMark;

@Singleton 
public class MarkController extends AbstractMarkController{
	
	@Inject
	public MarkController(IMark mark) {
		this.mark = mark;
	}
}
