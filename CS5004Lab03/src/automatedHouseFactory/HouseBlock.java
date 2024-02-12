package automatedHouseFactory;

import java.util.ArrayList;

public class HouseBlock<Blooean, blooean> extends Block {
	
	// build house with exception check for resource amount TODO check with Jingjing, take block instead of resource
	
	/*I think my thinking there was having to set up a generic type 
	 * and then split it based on the block accepted or having to send it multiple blocks at once like an array list. 
	 * If you think you have it set up to do this, go ahead and then claim it as an extension
	*/
	
	public HouseBlock(ArrayList<Block> blockArray) throws IllegalArgumentException {
		super(blockArray);

		if(blockCheckForHouseBlockFactory(blockArray) != true) {
			throw new IllegalArgumentException("Provided resource is insufficient to build HouseBlock.\n");
		}
	}
	
	
	// helper method to check each block type and weight in the block array list TODO extension
	
	private boolean blockCheckForHouseBlockFactory(ArrayList<Block> blockArray) {
		
		for(int j = 0; j < blockArray.size(); j++) {
			System.out.println("HouseBlock insdie + " + blockArray.get(j));
		}
		
		// get each block in block array list
		for(int i = 0; i < blockArray.size(); i++) {
			
			Block block = blockArray.get(i);
			
			// if block type is house then return false
			if(block.getType() == ResourceType.HOUSE) {
				return false;
			}
			else if(
					// check if block is wood and weight is sufficient then check stone weight below
					block.getType() == ResourceType.WOOD && block.getWeight() < Const.woodBlockNumberHouse * Const.aWoodBlockWeight || block.getType() == ResourceType.STONE && block.getWeight() < Const.stoneBlockNumberHouse * Const.aStoneBlockWeight) {
				return false;
			}
		}
		return true;
	}

	
	
	@Override // return total weight wood for a house
	public Resource breakBlock() {
		
		return new Resource(Const.woodBlockNumberHouse * Const.aWoodBlockWeight, ResourceType.WOOD);
	}
	
}
