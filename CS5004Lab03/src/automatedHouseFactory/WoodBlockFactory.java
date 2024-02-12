package automatedHouseFactory;

public class WoodBlockFactory implements Factory {	
	
	// raw wood material inventory
	public double wResourceBin;
	
	// Constructor
	public WoodBlockFactory() {};
	
	
	@Override
	public void takeResource(Object resource) throws IllegalArgumentException{

		// check if resource is Resource type
		if(resource instanceof Resource) {
			
			// cast resource to Resource type
			Resource castResource = (Resource) resource;
			
			// check if resource type is wood, cast Object to Resource
			if(castResource.getType() == ResourceType.WOOD) {
				
					// take wood weight from resource and add to wResourceBin
					wResourceBin += castResource.getWeight();
				}
			else {
					throw new IllegalArgumentException("The input resource for WoodBlockFactory is not wood.\n");
				}
			 }
		else {
			throw new IllegalArgumentException("Resource for WoodBlockFactory is invalid.\n");
		}
	}

	
	@Override
	public Block produce() {
		
		// check if wood inventory is sufficient to build woodBlock
		if(wResourceBin - Const.aWoodBlockWeight > 0.00000001) {
			
			// if wood is sufficient then subtract the cost of woodBlock from inventory
			wResourceBin -= Const.aWoodBlockWeight;
			
			// woodBlock built
			return new WoodBlock();
		}
		else {
			return null;
		}
	}

	@Override
	public void displayInventory() {
		System.out.printf("%.1f\n", wResourceBin);
	}

}
