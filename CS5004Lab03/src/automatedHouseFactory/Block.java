package automatedHouseFactory;

import java.util.ArrayList;

/*
Name: Xuedinan Gao
Course: CS 5004
Semester: Spring 2024
*/

public abstract class Block{
	
	static ResourceType type;
	static double weight;
	
	// return materials
	public abstract Resource breakBlock();
	
	//constructor
	public Block(ResourceType type, double weight) {
		Block.type = type;
		Block.weight = weight;
	}
	
	// check each element in block array list then create block accordingly
	public Block(ArrayList<Block> blockArray) {
		for(int j = 0; j < blockArray.size(); j++) {
		    
	    switch(blockArray.get(j).getType())
	        {
            	case HOUSE: Block.type = ResourceType.HOUSE; break;
	            case STONE: Block.type = ResourceType.STONE; break;
	            case WOOD: Block.type = ResourceType.WOOD; break;
	        }
		}
		Block.weight = houseBlockCalculate(blockArray);
	}

	// helper method for house block calculation
	private double houseBlockCalculate(ArrayList<Block> blockArray) throws IllegalArgumentException{
		
		double result = 0;
		
		for(int i = 0; i < blockArray.size(); i++) {
		
			// check if block type is in the resource type
			if(blockArray.get(i).getType() instanceof ResourceType == false) {
				throw new IllegalArgumentException("ResourceType is incorrect for Houseblock.\n");
			}
			
			// check if block type is in the house type
			else if (blockArray.get(i).getType() == ResourceType.HOUSE) {
				 throw new IllegalArgumentException("ResourceType is incorrect for Houseblock.\n");
			}
			else {
				
				// return the total weight (wood + stone + concrete) for a house
				result = Const.aStoneBlockWeight * Const.stoneBlockNumberHouse + 
						Const.aWoodBlockWeight * Const.woodBlockNumberHouse + 
						Const.aConcreteBlockWeight * Const.concreteBlockNumberHouse;
			}
		}
		return result;
	}

	// getters
	
	public ResourceType getType() {
		return type;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Type: " + type + ", " + "Weight: " + weight;
		
	}

	public void displayInventory() {
		
	}
}
