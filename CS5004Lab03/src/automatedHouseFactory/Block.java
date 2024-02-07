package automatedHouseFactory;

public abstract class Block extends Const {
	
	ResourceType type;
	double weight;
	
	
	// set block number to 0
	public abstract void breakBlock();
	
	//constructor
	public Block(ResourceType type, double weight) {
		this.type = type;
		this.weight = weight;
	}
	

	public Block(ResourceType type1, ResourceType type2) {
		this.type = ResourceType.house;
		this.weight = houseBlockCalculate(type1, type2);
		
	}
	
	
	// helper method for house block calculation TODO exception and condition
	private double houseBlockCalculate(ResourceType type1, ResourceType type2) {
		
		double result = 0;
		
		if (type1 != ResourceType.house && type2 != ResourceType.house) {
			result = Const.stoneBlockWeight * Const.stoneBlockNumberHouse + Const.woodBlockWeight + Const.woodBlockNumberHouse; 
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
}
