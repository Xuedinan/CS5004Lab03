package automatedHouseFactory;

import java.util.ArrayList;

public class HouseBlock<Blooean, blooean> extends Block {
	
	// build house with exception check for resource amount
	public HouseBlock(ArrayList<Block> blockArray) throws IllegalArgumentException {
		super(blockArray);
		
		// user helper method to check if block array list is sufficient to build house
		if(blockCheckForHouseBlockFactory(blockArray) != true) {
			throw new IllegalArgumentException("Provided resource is insufficient to build HouseBlock.\n");
		}
	}
	
	
	// helper method to check each block type and weight in the block array list TODO extension for Resource check
	
	private boolean blockCheckForHouseBlockFactory(ArrayList<Block> blockArray) {
		
		for(int j = 0; j < blockArray.size(); j++) {
			System.out.println("HouseBlock insdie + " + blockArray.get(j));
		}
		
		// get each block in block array list
		for(int i = 0; i < blockArray.size(); i++) {
			
			Block block = blockArray.get(i);
			
			// if block type is house then return false, make sure array list only has StoneBlock and WoodBlock
			if(block.getType() == ResourceType.HOUSE) {
				return false;
			}
			else if(
					// check if block is wood and weight is insufficient
					block.getType() == ResourceType.WOOD && block.getWeight() < Const.woodBlockNumberHouse * Const.aWoodBlockWeight || block.getType() == ResourceType.STONE && block.getWeight() < Const.stoneBlockNumberHouse * Const.aStoneBlockWeight) {
				return false;
			}
		}
		
		// ok to build house when all invalid case is not matched
		return true;
	}

	
	
	@Override // return total weight wood for a house
	public Resource breakBlock() {
		
		return new Resource(Const.woodBlockNumberHouse * Const.aWoodBlockWeight, ResourceType.WOOD);
	}
	
}
