package automatedHouseFactory;

import java.util.ArrayList;

/*
Name: Xuedinan Gao
Course: CS 5004
Semester: Spring 2024
*/

public class HouseFactory<T> implements Factory {
	
	// three block bins
	private double stoneBlockBin;
	private double woodBlockBin;
	private double concreteBlockBin;
	
	// create block array list for HouseBlock constructor
	public ArrayList<Block> blockArray = new ArrayList<>(3);

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
				
				// check if stone block bin reach out to max block number
				if(stoneBlockBin + castblock.getWeight() > Const.maxStoneBlockNumber) {
					stoneBlockBin = Const.maxStoneBlockNumber;
				}
				else{stoneBlockBin += castblock.getWeight();}
				
			}
			else if(castblock.getType() == ResourceType.WOOD) {
				
				// check if wood block bin reach out to max block number
				if(woodBlockBin + castblock.getWeight() > Const.maxWoodBlockNumber) {
					woodBlockBin = Const.maxWoodBlockNumber;
				}
				else {woodBlockBin += castblock.getWeight();}
			}
			
			else if(castblock.getType() == ResourceType.CONCRETE) {
				
				// check if concrete block bin reach out to max block number
				if(concreteBlockBin + castblock.getWeight() > Const.maxConcreteBlockNumber) {
					concreteBlockBin = Const.maxConcreteBlockNumber;
				}
				else {concreteBlockBin += castblock.getWeight();}
			}
		}
	}

	@Override //
	public HouseBlock produce() {
		
		// check if there is enough blocks
		if(stoneBlockBin >= Const.stoneBlockNumberHouse && 
				woodBlockBin >= Const.woodBlockNumberHouse &&
				concreteBlockBin >= Const.concreteBlockNumberHouse) {

			// when we have enough blocks, pass block to HouseBlock for constructor
			blockArray.add(new StoneBlock());
			blockArray.add(new WoodBlock());
			blockArray.add(new ConcreteBlock());
			
			
			// subtract blocks to build house
			stoneBlockBin -= Const.stoneBlockNumberHouse;
			woodBlockBin -= Const.woodBlockNumberHouse;
			concreteBlockBin -= Const.concreteBlockNumberHouse;
			
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
		System.out.printf("Stone Block: %.1f  Max number is: %.1f\n", stoneBlockBin, Const.maxStoneBlockNumber);
		System.out.printf("Wood Block: %.1f  Max number is: %.1f\n", woodBlockBin, Const.maxWoodBlockNumber);
		System.out.printf("Concrete Block: %.1f  Max number is: %.1f\n", concreteBlockBin, Const.maxConcreteBlockNumber);
	}
}