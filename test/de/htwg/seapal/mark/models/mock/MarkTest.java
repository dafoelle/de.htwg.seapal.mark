package de.htwg.seapal.mark.models.mock;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import de.htwg.seapal.mark.models.mock.Mark;

public class MarkTest {
	
	private Mark mark;

	@Before
	public void setup(){
		mark = new Mark();	
	}
	
	@Test
	public void testGetId() {
		UUID tmpId = UUID.fromString("00000000-0000-0000-0000-000000000000");
		UUID res = mark.getId();
		assertEquals(tmpId.compareTo(res), 0);
	}
	
	@Test
	public void testGetName() {
		assertEquals("testMark", mark.getName());
	}
	
	@Test
	public void testSetName() {
		mark.setName("customString");
		assertEquals("testMark", mark.getName());
	}

	@Test
	public void testGetColor() {
		assertEquals(Color.BLACK, mark.getColor());
	}
	
	@Test
	public void testSetColor() {
		mark.setColor(Color.RED);
		assertEquals(Color.BLACK, mark.getColor());
	}
	
	@Test
	public void testGetFunction() {
		assertEquals("TestFunction", mark.getFunction());
	}
	
	@Test
	public void testSetFunction() {
		mark.setFunction("customString");
		assertEquals("TestFunction", mark.getFunction());
	}
	
	@Test
	public void testGetIsDay() {
		assertFalse(mark.getIsDay());
	}
	
	@Test
	public void testSetIsDay() {
		mark.setIsDay(true);
		assertFalse(mark.getIsDay());
	}
	
	@Test
	public void testGetIsNight() {
		assertFalse(mark.getIsNight());
	}
	
	@Test
	public void testSetIsNight() {
		mark.setIsNight(true);
		assertFalse(mark.getIsNight());
	}
	
	@Test
	public void testGetLatitude() {
		assertEquals(Double.doubleToLongBits(5.0), Double.doubleToLongBits(mark.getLatitude()));
	}
	
	@Test
	public void testSetLatitude() {
		mark.setLatitude(0.0);
		assertEquals(Double.doubleToLongBits(5.0), Double.doubleToLongBits(mark.getLatitude()));
	}
	
	@Test
	public void testGetLongitude() {
		assertEquals(Double.doubleToLongBits(6.0), Double.doubleToLongBits(mark.getLongitude()));
	}
	
	@Test
	public void testSetLongitude() {
		mark.setLongitude(0.0);
		assertEquals(Double.doubleToLongBits(6.0), Double.doubleToLongBits(mark.getLongitude()));
	}
	
	@Test
	public void testGetType() {
		assertEquals("TestMarkType", mark.getMarkType());
	}
	
	@Test
	public void testSetType() {
		mark.setMarkType("customString");
		assertEquals("TestMarkType", mark.getMarkType());
	}
}
