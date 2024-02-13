package automatedHouseFactory;
import java.util.Random;
import java.lang.Math;

/*
	Name: Xuedinan Gao
	Course: CS 5004
	Semester: Spring 2024

*/

public class Main
{
	public static void main(String[] args) throws InterruptedException {
		
		Resource resource; // define resource for the objects below
		
		// create block factory for stone, wood, concrete
		Factory stoneBlockProducer = new StoneBlockFactory();
		Factory woodBlockProducer = new WoodBlockFactory();
		Factory concreteBlockProducer = new ConcreteBlockFactory();
		
		// create house factory
		Factory houseBlockProducer = new HouseFactory();
		
		Block h1;
		
		//Infinite simulation loop CTRL + C to terminate simulation
		while(true)
		{	
			// take resource with checking type
		    resource = mineResource();
		
		    switch(resource.getType()) // check resource type then return weight to relevant block factory
		    {
			    case STONE: stoneBlockProducer.takeResource(resource); break;
			    case WOOD: woodBlockProducer.takeResource(resource); break;
			    case CONCRETE: concreteBlockProducer.takeResource(resource); break;
		    }
		    
		    // create resource block then pass to house block factory block inventory
    		houseBlockProducer.takeResource(stoneBlockProducer.produce());
    		houseBlockProducer.takeResource(woodBlockProducer.produce());
    		houseBlockProducer.takeResource(concreteBlockProducer.produce());
    		
    		// once have all sufficient inventory for each block, then build a house
    		h1 = houseBlockProducer.produce();
    		
    		if (h1 != null) System.out.println("House Built");
    		
    		h1 = null;
    		
    		// print out inventory, I added max inventory for each type block
    		System.out.println("Stone Producer");
    		stoneBlockProducer.displayInventory();
    		System.out.println("Wood Producer");
    		woodBlockProducer.displayInventory();
    		System.out.println("Concrete Producer");
    		concreteBlockProducer.displayInventory();
    		System.out.println("House Producer");
    		houseBlockProducer.displayInventory();
    		
    		System.out.println();
    		
    		//pauses simulation for 2 seconds so it is visable
    		
    		Thread.sleep(2000);
		}
	}
	
	//generate a random Resource with a random weight
	public static Resource mineResource()
	{	
		// create random object
	    Random r = new Random();
	    
	    // create a resource type variable to receive random weight, will cast type later
	    ResourceType type = ResourceType.STONE;
	    
	    // get random weight in the range 0-10
	    double weight = Math.round((Math.abs(r.nextDouble()))*100.0)/10.0 ;
	    
	    // get random number in the range 0-3 for switch case use below
	    int select = r.nextInt(3);
	    
	    switch(select)
	        {	
	    		// match "select" number with each case below, then return relevant recourse object
	            case 0: type = ResourceType.STONE; break;
	            case 1: type = ResourceType.WOOD; break;
	            case 2: type = ResourceType.CONCRETE; break;
	        }
	   
	   // return new resource with weight and type
	   return new Resource(weight, type);
	}
}