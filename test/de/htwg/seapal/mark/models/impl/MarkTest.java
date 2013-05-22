package de.htwg.seapal.mark.models.impl;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.htwg.seapal.mark.models.impl.Mark;

public class MarkTest {
	
	private Mark mark;

	@Before
	public void setup(){
		mark = new Mark();	
	}
	
	@Test 
	public void testId() {
		Assert.assertNotNull(mark.getId());
	}
	
	@Test
	public void testName() {
		mark.setName("testString");
		assertEquals("testString", mark.getName());
	}

	@Test
	public void testColor() {
		mark.setColor("red");
		assertEquals("red", mark.getColor());
	}
	
	@Test
	public void testFunktion() {
		mark.setFunction("testString");
		assertEquals("testString", mark.getFunction());
	}
	
	@Test
	public void testIsDay() {
		mark.setIsDay(false);
		assertFalse(mark.getIsDay());
	}
	
	@Test
	public void testIsNight() {
		mark.setIsNight(false);
		assertFalse(mark.getIsNight());
	}
	
	@Test
	public void testLatitude() {
		mark.setLatitude(0.4);
		assertEquals(Double.doubleToLongBits(0.4), Double.doubleToLongBits(mark.getLatitude()));
	}
	
	@Test
	public void testLongitude() {
		mark.setLongitude(0.4);
		assertEquals(Double.doubleToLongBits(0.4), Double.doubleToLongBits(mark.getLongitude()));
	}
	
	@Test
	public void testType() {
		mark.setMarkType("testString");
		assertEquals("testString", mark.getMarkType());
	}
}
