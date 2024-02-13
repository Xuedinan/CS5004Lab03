package automatedHouseFactoryTest;

import static org.junit.Assert.*;

import org.junit.Test;

import automatedHouseFactory.Resource;
import automatedHouseFactory.ResourceType;

public class ResourceTest {
	
	
	Resource test1 = new Resource(10, ResourceType.STONE);
	Resource test2= new Resource(20, ResourceType.WOOD);
	
	
	@Test
	public void getTest() {
		
		assertEquals(10, test1.getWeight(), 0.01);
		assertEquals(20, test2.getWeight(), 0.01);
		assertEquals(ResourceType.STONE, test1.getType());
		assertEquals(ResourceType.WOOD, test2.getType());
	}
	
	@Test
	public void addWeightTest() {
		
		test1.addWeight(10);
		test2.addWeight(10);
		
		assertEquals(20, test1.getWeight(), 0.01);
		assertEquals(30, test2.getWeight(), 0.01);
	}
	
	
	@Test
	public void subWeightTest() {
		
		test1.subWeight(3);
		test2.subWeight(5);
		
		assertEquals(7, test1.getWeight(), 0.01);
		assertEquals(15, test2.getWeight(), 0.01);
	}
	
}
