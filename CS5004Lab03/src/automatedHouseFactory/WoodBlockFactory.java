package automatedHouseFactory;

public class WoodBlockFactory implements Factory {	
	
	// raw wood material inventory
	private Resource resourceBin;
	
	
	public WoodBlockFactory() {};
	
	
	@Override
	public <T> void takeResource(Object resource) throws IllegalArgumentException{
		
		// check if resource is null
		if(resource == null) {
			throw new IllegalArgumentException("The input resource for woodBlockFactory can't be null.\n");
		}
		
		// check if resource is Resource type
		else if(resource instanceof ResourceType) {
			
			// check if resource type is wood, cast Object to Resource
			if(((Resource) resource).getType() == ResourceType.WOOD) {
				
					// take wood weight from resource and add to resourceBin
					resourceBin.addWeight(((Resource) resource).getWeight());
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
		if(resourceBin.getWeight() - Const.aWoodBlockWeight > 0.00000001) {
			
			// if wood is sufficient then subtract the cost of woodBlock from inventory
			resourceBin.subWeight(Const.aWoodBlockWeight);
			
			// woodBlock built
			return new WoodBlock();
		}
		else {
			return null; // TODO check with Jingjing
		}
	}

	@Override
	public Object displayInventory() {
		return resourceBin.getWeight();
		
	}


}
