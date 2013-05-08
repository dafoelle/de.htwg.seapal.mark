package de.htwg.seapal.mark.controllers.mock;

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

import de.htwg.seapal.mark.app.MarkMockModule;
import de.htwg.seapal.mark.controllers.IMarkController;

public class MarkControllerTest {

	private IMarkController mark;
	// Set up Google Guice Dependency Injector
	Injector injector = Guice.createInjector(new MarkMockModule());
	IMarkController controller;
	UUID markId;
	
	@Before
	public void setup(){
		// Build up the application, resolving dependencies automatically by Guice
		mark = injector.getInstance(IMarkController.class);
		controller = injector.getInstance(IMarkController.class);
		markId = controller.newMark();
	}
	
	@After
	public void tierdown() {
		controller.closeDB();
	}
	
	@Test
	public void testMarkName() {
		mark.setMarkName(markId, "testString");
		assertEquals("testMark", mark.getMarkName(markId));
	}

	@Test
	public void testMarkColor() {
		mark.setMarkColor(markId, Color.red);
		assertEquals(Color.BLACK, mark.getMarkColor(markId));
	}
	
	@Test
	public void testMarkFunktion() {
		mark.setMarkFunction(markId, "testString");
		assertEquals("TestFunction", mark.getMarkFunction(markId));
	}
	
	@Test
	public void testMarkIsDay() {
		mark.setMarkIsDay(markId, true);
		assertFalse(mark.getMarkIsDay(markId));
	}
	
	@Test
	public void testMarkIsNight() {
		mark.setMarkIsNight(markId, true);
		assertFalse(mark.getMarkIsNight(markId));
	}
	
	@Test
	public void testLatitude() {
		mark.setMarkLatitude(markId, 0.4);
		assertEquals(Double.doubleToLongBits(5.0), Double.doubleToLongBits(mark.getMarkLatitude(markId)));
	}
	
	@Test
	public void testLongitude() {
		mark.setMarkLongitude(markId, 0.4);
		assertEquals(Double.doubleToLongBits(6.0), Double.doubleToLongBits(mark.getMarkLongitude(markId)));
	}
	
	@Test
	public void testMarkType() {
		mark.setMarkType(markId, "testString"); 
		assertEquals("TestMarkType", mark.getMarkType(markId));
	}
	
	@Test
	public void testGetString() {
		Assert.assertNotSame("", mark.getString(markId));
	}
	
	@Test
	public void testGetMarks() {
		assertNull(mark.getMarks());
	}
	
	@Test
	public void testDeleteMark() {
		mark.deleteMark(markId);
	}

}
