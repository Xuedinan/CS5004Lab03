package automatedHouseFactory;

/*
 * My driver testing will follow below work-flow
 * 
 * 1. create three type resources
 * 2. create three block factory
 * 3. create one house factory
 * 4. add weight, subtract weight to all resources 
 * 5. product blocks for each resource
 * 6. break blocks
 * 7. receive returned resource
 * 8. transfer returned resource to block factories
 * 9. try to build house
 * 10. if blocks are not enough, add more block then produce
 * 11. break house check what be returned
 * 
 * 
 */

public class NewDriver {

	public static void main(String[] args) throws InterruptedException {
		
		// create three resource as starting point
		Resource stoneRe = new Resource(2, ResourceType.STONE); 
		Resource woodRe = new Resource(2, ResourceType.WOOD); 
		Resource concreteRe = new Resource(2, ResourceType.CONCRETE); 
		
		// create block factory for stone, wood, concrete
		Factory stoneBlockProducer = new StoneBlockFactory();
		Factory woodBlockProducer = new WoodBlockFactory();
		Factory concreteBlockProducer = new ConcreteBlockFactory();
		
		// create house factory
		Factory houseBlockProducer = new HouseFactory();
		
		
		System.out.println("----- At begianing, we have ----- \n");
		System.out.println("Stone weight: " + stoneRe.getWeight());
		System.out.println("Wood weight: " + woodRe.getWeight());
		System.out.println("Concrete weight: " + concreteRe.getWeight());
		
		System.out.println("\nNow, we add weight 2 to each of them.\n");
		
		// add weight
		stoneRe.addWeight(2);
		woodRe.addWeight(2);
		concreteRe.addWeight(2);
		
		System.out.println("----- Then, we have ----- \n");
		System.out.println("Stone weight: " + stoneRe.getWeight());
		System.out.println("Wood weight: " + woodRe.getWeight());
		System.out.println("Concrete weight: " + concreteRe.getWeight());
		
		System.out.println("\nContinue, we subtrack weight 1 to each of them.\n");
		
		// sub weight
		stoneRe.subWeight(1);
		woodRe.subWeight(1);
		concreteRe.subWeight(1);
		
		System.out.println("----- Then, we have ----- \n");
		System.out.println("Stone weight: " + stoneRe.getWeight());
		System.out.println("Wood weight: " + woodRe.getWeight());
		System.out.println("Concrete weight: " + concreteRe.getWeight());
		
		System.out.println("\nOkay, we pass all resources to factory to produce blocks.\n");
		// pass resource objects to block factory
		stoneBlockProducer.takeResource(stoneRe);
		woodBlockProducer.takeResource(woodRe);;
		concreteBlockProducer.takeResource(concreteRe);
		
		System.out.println("Producing Blocks - 50%");
		Thread.sleep(800);
		System.out.println("Producing Blocks - 80%");
		Thread.sleep(800);
		System.out.println("Producing Blocks - 100%");
		Thread.sleep(800);
		
		// produce block by adding resource to factory
		StoneBlock sb = (StoneBlock) stoneBlockProducer.produce();
		WoodBlock wb = (WoodBlock) woodBlockProducer.produce();
		ConcreteBlock cb = (ConcreteBlock) concreteBlockProducer.produce();
		
		System.out.println("\n----- Then, we have ----- \n");
		System.out.println("Stone block: " + sb.getWeight());
		System.out.println("Wood block: " + wb.getWeight());
		System.out.println("Concrete block: " + cb.getWeight());
		
		System.out.println("\nNow, we break blocks that we just created, and return raw material to resources\n");
		
		// receive returned resource from broken block
		Resource sbTemp = sb.breakBlock();
		Resource wbTemp = wb.breakBlock();
		Resource cbTemp = cb.breakBlock();
		
		// take weight and add to relevant resource	
		stoneRe.addWeight(sbTemp.getWeight());
		woodRe.addWeight(wbTemp.getWeight());
		concreteRe.addWeight(cbTemp.getWeight());
		
		System.out.println("----- Then, we have ----- \n");
		System.out.println("Stone weight: " + stoneRe.getWeight());
		System.out.println("Wood weight: " + woodRe.getWeight());
		System.out.println("Concrete weight: " + concreteRe.getWeight());
		
		System.out.println("\n----- Create more blocks and Build House-----\n");
		// pass resource objects to block factory
		stoneBlockProducer.takeResource(stoneRe);
		woodBlockProducer.takeResource(woodRe);;
		concreteBlockProducer.takeResource(concreteRe);
		
		System.out.println("Producing House - 50%");
		Thread.sleep(800);
		System.out.println("Producing House - 80%");
		Thread.sleep(800);
		System.out.println("Producing House - 100%");
		Thread.sleep(800);
		System.out.println("");

		// pass block objects to House factory
		houseBlockProducer.takeResource(stoneBlockProducer.produce());
		houseBlockProducer.takeResource(woodBlockProducer.produce());
		houseBlockProducer.takeResource(concreteBlockProducer.produce());
		houseBlockProducer.displayInventory();
		
		System.out.println("\n----- Since blocks are not enough to build House, add more blocks -----\n");
		
		houseBlockProducer.takeResource(new WoodBlock());
		houseBlockProducer.takeResource(new ConcreteBlock());
		
		System.out.println("\n----- Check Block Bin status -----\n");
		houseBlockProducer.displayInventory();
		
		System.out.println("\n===== House Built! =====\n");
		HouseBlock hb = (HouseBlock) houseBlockProducer.produce();
		
		System.out.println("\n----- Check Block Bin status -----\n");
		houseBlockProducer.displayInventory();

		System.out.println("\n----- Break House -----\n");
		Resource result = hb.breakBlock();
		
		System.out.println("Breaking House - 50%");
		Thread.sleep(800);
		System.out.println("Breaking House - 80%");
		Thread.sleep(800);
		System.out.println("Breaking House - 100%");
		Thread.sleep(800);
		System.out.println("");
		
		System.out.println("This is what left.");
		System.out.println("Type: " + result.getType());
		System.out.println("weight: " + result.getWeight());

	}

}
