package automatedHouseFactory;

import java.util.ArrayList;

public class HouseFactory<T> implements Factory {
	
	// two block bins
	private double stoneBlockBin;
	private double woodBlockBin;
	
	// create block array list for HouseBlock constructor
	public ArrayList<Block> blockArray = new ArrayList<>(2);

	@Override
	public void takeResource(Object resource) throws IllegalArgumentException{

		// check if resource is null
		if(resource == null) {
			return;
		}
		
		// cast resource to block
		Block castblock = (Block) resource;
		
		if (!(castblock instanceof Block)) {
			
			throw new IllegalArgumentException("Resource must be block for houseFactory takeResource method.\n");
		}
		else {
			
			// check if this is stone block or wood block, then add weight into block bin
			if(castblock.getType() == ResourceType.STONE) {
				stoneBlockBin += castblock.getWeight();
			}
			else if(castblock.getType() == ResourceType.WOOD) {
				woodBlockBin += castblock.getWeight();
			}
		}
	}

	@Override // TODO extension
	public Block produce() {
		
		// check if there is enough blocks
		if(stoneBlockBin >= Const.stoneBlockNumberHouse && woodBlockBin >= Const.woodBlockNumberHouse) {

			// when we have enough blocks, pass block to HouseBlock for constructor
			blockArray.add(new StoneBlock());
			blockArray.add(new WoodBlock());
			
			// subtract blocks to build house
			stoneBlockBin -= Const.stoneBlockNumberHouse;
			woodBlockBin -= Const.woodBlockNumberHouse;
			
			// use temp array list to store current array list and reset array list after each while loop
			ArrayList<Block> temp = blockArray;
			blockArray = new ArrayList<Block>();
			
			return new HouseBlock(temp);
			
		}else {
			
			// null if blocks are not enough to build house
			return null;
		}
	}


	@Override
	public void displayInventory() {
		System.out.printf("Stone Block: %.1f\n", stoneBlockBin);
		System.out.printf("Wood Block: %.1f\n ", woodBlockBin);
	}
}