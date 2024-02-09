package automatedHouseFactory;

public class HouseBlock extends Block {
	
	// build house with exception check for resource amount TODO check with Jingjing
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
