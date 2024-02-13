package automatedHouseFactoryTest;

import static org.junit.Assert.*;

import org.junit.Test;

import automatedHouseFactory.WoodBlock;
import automatedHouseFactory.WoodBlockFactory;
import automatedHouseFactory.Resource;
import automatedHouseFactory.ResourceType;

/*
Name: Xuedinan Gao
Course: CS 5004
Semester: Spring 2024
*/

public class WoodBlockFactoryTest {
	
	WoodBlockFactory wbf = new WoodBlockFactory();
	WoodBlock wb = new WoodBlock();
	Resource Wood = new Resource(6, ResourceType.WOOD);
	
	
	@Test
	public void constructorTest() {
		
		// default weight is 2
		assertEquals(2, wb.getWeight(), 0.01);
		assertEquals(ResourceType.WOOD, wb.getType());
	}
	
	
	@Test
	public void takeResourceTest() {
		
		// take resource from Wood
		wbf.takeResource(Wood);
		
		// check if Wood block is created
		WoodBlock testWood = (WoodBlock) wbf.produce();
		
		assertEquals(ResourceType.WOOD, testWood.getType());
		assertEquals(2, testWood.getWeight(), 0.01);
	}

}