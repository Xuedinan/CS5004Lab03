 package automatedHouseFactory;
 
 /*
 Name: Xuedinan Gao
 Course: CS 5004
 Semester: Spring 2024
 */

public class StoneBlockFactory implements Factory {
	
	// raw stone material inventory
	public double sResourceBin;
	
	// constructor
	public StoneBlockFactory() {};
	
	
	@Override
	public void takeResource(Object resource) throws IllegalArgumentException{
		
		// check if resource is Resource type
		if(resource instanceof Resource) {
			
			// cast resource to Resource type
			Resource castResource = (Resource) resource;
			
			// check if resource type is stone, cast Object to Resource
			if(castResource.getType() == ResourceType.STONE) {
				
					// take stone weight from resource and add to sResourceBin
					sResourceBin += castResource.getWeight();
				}
			else {
					throw new IllegalArgumentException("The input resource for StoneBlockFactory is not stone.\n");
				}
			 }
		else {
			throw new IllegalArgumentException("Resource for StoneBlockFactory is invalid.\n");
		}
	}

	
	@Override
	public Block produce() {

		// check if stone inventory is sufficient to build stoneBlock
		if((sResourceBin - Const.aStoneBlockWeight) > 0.00000001) {
			
			// if stone is sufficient then subtract the cost of stoneBlock from inventory
			sResourceBin -= Const.aStoneBlockWeight;
			
			// stoneBlock built
			return new StoneBlock();
		}
		else {
			return null;
		}
	}

	@Override
	public void displayInventory() {
		System.out.printf("%.1f\n", sResourceBin);
	}

}
