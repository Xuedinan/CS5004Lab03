 package automatedHouseFactory;

public class StoneBlockFactory implements Factory {
	
	// raw stone material inventory
	private Resource resourceBin;
	
	
	public StoneBlockFactory() {};
	
	
	@Override
	public <T> void takeResource(Object resource) throws IllegalArgumentException{
		
		// check if resource is null
		if(resource == null) {
			throw new IllegalArgumentException("The input resource for stoneBlockFactory can't be null.\n");
		}
		
		// check if resource is Resource type
		else if(resource instanceof ResourceType) {
			
			// check if resource type is stone, cast Object to Resource
			if(((Resource) resource).getType() == ResourceType.STONE) {
				
					// take stone weight from resource and add to resourceBin
					resourceBin.addWeight(((Resource) resource).getWeight());
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
		if(resourceBin.getWeight() - Const.aStoneBlockWeight > 0.00000001) {
			
			// if stone is sufficient then subtract the cost of stoneBlock from inventory
			resourceBin.subWeight(Const.aStoneBlockWeight);
			
			// stoneBlock built
			return new StoneBlock();
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
