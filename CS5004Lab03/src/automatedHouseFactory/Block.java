package automatedHouseFactory;

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
	
	// TODO double check weight
	public Block(Resource type1, Resource type2) {
		Block.type = ResourceType.HOUSE;
		Block.weight = houseBlockCalculate(type1, type2);
		
	}

	// helper method for house block calculation TODO added exception
	private double houseBlockCalculate(Resource type1, Resource type2) throws IllegalArgumentException{
		
		double result = 0;
		
		if(type1.getType() instanceof ResourceType == false || type2.getType() instanceof ResourceType == false) {
			throw new IllegalArgumentException("ResourceType is incorrect for Houseblock.\n");
		}
		
		else if (type1.getType() != ResourceType.HOUSE || type2.getType() != ResourceType.HOUSE) {
			 throw new IllegalArgumentException("ResourceType is incorrect for Houseblock.\n");
		}
		else {
			result = Const.aStoneBlockWeight * Const.stoneBlockNumberHouse + Const.aWoodBlockWeight + Const.woodBlockNumberHouse;
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
