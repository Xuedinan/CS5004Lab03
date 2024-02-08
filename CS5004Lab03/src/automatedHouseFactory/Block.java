package automatedHouseFactory;

public abstract class Block extends Const {
	
	static ResourceType type;
	protected static double weight;
	
	
	// return materials
	public abstract Resource breakBlock();
	
	//constructor
	public Block(ResourceType type, double weight) {
		Block.type = type;
		this.weight = weight;
	}
	
	// TODO double check weight
	public Block(ResourceType type1, ResourceType type2) {
		Block.type = ResourceType.HOUSE;
		this.weight = houseBlockCalculate(type1, type2);
		
	}
	
	public Block() {
	}

	// helper method for house block calculation TODO exception and condition
	private double houseBlockCalculate(ResourceType type1, ResourceType type2) {
		
		double result = 0;
		
		if (type1 != ResourceType.HOUSE && type2 != ResourceType.HOUSE) {
			result = Const.aStoneBlockWeight * Const.stoneBlockNumberHouse + Const.aWoodBlockWeight + Const.woodBlockNumberHouse; 
		}
		
		return result;
	}


	// getters
	
	public static ResourceType getType() {
		return type;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Type: " + type + ", " + "Weight: " + weight;
		
	}
}
