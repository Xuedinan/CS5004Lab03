package automatedHouseFactoryTest;

import static org.junit.Assert.*;

import org.junit.Test;

import automatedHouseFactory.StoneBlock;
import automatedHouseFactory.StoneBlockFactory;
import automatedHouseFactory.Resource;
import automatedHouseFactory.ResourceType;

/*
Name: Xuedinan Gao
Course: CS 5004
Semester: Spring 2024
*/

public class StoneBlockFactoryTest {
	
	StoneBlockFactory sbf = new StoneBlockFactory();
	StoneBlock sb = new StoneBlock();
	Resource Stone = new Resource(6, ResourceType.STONE);
	
	
	@Test
	public void constructorTest() {
		
		// default weight is 2
		assertEquals(2, sb.getWeight(), 0.01);
		assertEquals(ResourceType.STONE, sb.getType());
	}
	
	
	@Test
	public void takeResourceTest() {
		
		// take resource from Stone
		sbf.takeResource(Stone);
		
		// check if Stone block is created
		StoneBlock testStone = (StoneBlock) sbf.produce();
		
		assertEquals(ResourceType.STONE, testStone.getType());
		assertEquals(2, testStone.getWeight(), 0.01);
	}

}
