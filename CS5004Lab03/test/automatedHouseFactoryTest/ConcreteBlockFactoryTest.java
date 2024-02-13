package automatedHouseFactoryTest;

import static org.junit.Assert.*;

import org.junit.Test;

import automatedHouseFactory.ConcreteBlock;
import automatedHouseFactory.ConcreteBlockFactory;
import automatedHouseFactory.Resource;
import automatedHouseFactory.ResourceType;

public class ConcreteBlockFactoryTest {
	
	ConcreteBlockFactory cbf = new ConcreteBlockFactory();
	ConcreteBlock cb = new ConcreteBlock();
	Resource concrete = new Resource(6, ResourceType.CONCRETE);
	
	
	@Test
	public void constructorTest() {
		
		// default weight is 2
		assertEquals(2, cb.getWeight(), 0.01);
		assertEquals(ResourceType.CONCRETE, cb.getType());
	}
	
	
	@Test
	public void takeResourceTest() {
		
		// take resource from concrete
		cbf.takeResource(concrete);
		
		// check if concrete block is created
		ConcreteBlock testConcrete = (ConcreteBlock) cbf.produce();
		
		assertEquals(ResourceType.CONCRETE, testConcrete.getType());
		assertEquals(2, testConcrete.getWeight(), 0.01);
	}

}
