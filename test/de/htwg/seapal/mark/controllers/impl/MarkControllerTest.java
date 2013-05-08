package de.htwg.seapal.mark.controllers.impl;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Map;
import java.util.UUID;

import junit.framework.Assert;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.seapal.mark.app.MarkImplModule;
import de.htwg.seapal.mark.controllers.IMarkController;

public class MarkControllerTest {

	private IMarkController mark;
	// Set up Google Guice Dependency Injector
	Injector injector;
	IMarkController controller;
	UUID markId;
/*	
	@Before
	public void setup(){
		// Build up the application, resolving dependencies automatically by Guice
		injector = Guice.createInjector(new MarkImplModule());
		mark = injector.getInstance(IMarkController.class);
		controller = injector.getInstance(IMarkController.class);
		markId = controller.newMark();
	}
	
	@Test
	public void testMarkName() {
		mark.setMarkName(markId, "testString");
		assertEquals("testString", mark.getMarkName(markId));
	}

	@Test
	public void testMarkColor() {
		mark.setMarkColor(markId, Color.red);
		assertEquals(Color.red, mark.getMarkColor(markId));
	}
	
	@Test
	public void testMarkFunktion() {
		mark.setMarkFunction(markId, "testString");
		assertEquals("testString", mark.getMarkFunction(markId));
	}
	
	@Test
	public void testMarkIsDay() {
		mark.setMarkIsDay(markId, true);
		assertTrue(mark.getMarkIsDay(markId));
	}
	
	@Test
	public void testMarkIsNight() {
		mark.setMarkIsNight(markId, true);
		assertTrue(mark.getMarkIsNight(markId));
	}
	
	@Test
	public void testLatitude() {
		mark.setMarkLatitude(markId, 0.4);
		assertEquals(Double.doubleToLongBits(0.4), Double.doubleToLongBits(mark.getMarkLatitude(markId)));
	}
	
	@Test
	public void testLongitude() {
		mark.setMarkLongitude(markId, 0.4);
		assertEquals(Double.doubleToLongBits(0.4), Double.doubleToLongBits(mark.getMarkLongitude(markId)));
	}
	
	@Test
	public void testMarkType() {
		mark.setMarkType(markId, "testString"); 
		assertEquals("testString", mark.getMarkType(markId));
	}
	
	@Test
	public void testGetString() {
		Assert.assertNotSame("", mark.getString(markId));
	}
	
	@Test
	public void testGetMarks() {
		Map<String, String> tmp = mark.getMarks();
		assertFalse(tmp.entrySet().isEmpty());
	}
	
	@Test
	public void testDeleteMark() {
		mark.deleteMark(markId);
		assertNull(null, mark.getMarkName(markId));
	}
	
	@After
	public void tierdown() {
		controller.closeDB();
	}
*/
}
