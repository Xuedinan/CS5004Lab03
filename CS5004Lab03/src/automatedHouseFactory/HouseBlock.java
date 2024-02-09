package automatedHouseFactory;

public class HouseBlock extends Block {
	
	// build house with exception check for resource amount TODO check with Jingjing
	
	/*I think my thinking there was having to set up a generic type 
	 * and then split it based on the block accepted or having to send it multiple blocks at once like an array list. 
	 * If you think you have it set up to do this, go ahead and then claim it as an extension
	*/
	
	public HouseBlock(Resource wood, Resource stone) throws IllegalArgumentException {
		super(wood,stone);
		
		if(wood.getWeight() >= Const.woodBlockNumberHouse * Const.aWoodBlockWeight && stone.getWeight() >= Const.stoneBlockNumberHouse * Const.aStoneBlockWeight) {	
		}
		else {
			throw new IllegalArgumentException("Provided resource is insufficient to build HouseBlock.\n");
		}
	}

	@Override // return total weight wood for a house
	public Resource breakBlock() {
		
		return new Resource(Const.woodBlockNumberHouse * Const.aWoodBlockWeight, ResourceType.WOOD);
	}
	
}
