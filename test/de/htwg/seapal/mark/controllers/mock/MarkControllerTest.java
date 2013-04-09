package de.htwg.seapal.mark.controllers.mock;

import static org.junit.Assert.*;

import java.awt.Color;


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

	
	@Before
	public void setup(){
		// Build up the application, resolving dependencies automatically by Guice
		mark = injector.getInstance(IMarkController.class);
	}
	
	@Test
	public void testMarkName() {
		mark.setMarkName("testString");
		assertEquals("testString", mark.getMarkName());
	}

	@Test
	public void testMarkColor() {
		mark.setMarkColor(Color.red);
		assertEquals(Color.red, mark.getMarkColor());
	}
	
	@Test
	public void testMarkFunktion() {
		mark.setMarkFunction("testString");
		assertEquals("testString", mark.getMarkFunktion());
	}
	
	@Test
	public void testMarkIsDay() {
		mark.setMarkIsDay(false);
		assertFalse(mark.getMarkIsDay());
	}
	
	@Test
	public void testMarkIsNight() {
		mark.setMarkIsNight(false);
		assertFalse(mark.getMarkIsNight());
	}
	
	@Test
	public void testLatitude() {
		mark.setMarkLatitude(0.4);
		assertEquals(Double.doubleToLongBits(0.4), Double.doubleToLongBits(mark.getMarkLatitude()));
	}
	
	@Test
	public void testLongitude() {
		mark.setMarkLongitude(0.4);
		assertEquals(Double.doubleToLongBits(0.4), Double.doubleToLongBits(mark.getMarkLongitude()));
	}
	
	@Test
	public void testMarkType() {
		mark.setMarkType("testString");
		assertEquals("testString", mark.getMarkType());
	}

}
