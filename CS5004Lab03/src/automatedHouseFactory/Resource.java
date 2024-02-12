package automatedHouseFactory;

public class Resource {
	
	private double weight;
	private ResourceType type;
	
	
	// constructor
	public Resource(double weight, ResourceType type) {

		this.weight = weight;
		this.type = type;
	}

	// getters
	public double getWeight() {
		return weight;
	}


	public ResourceType getType() {
		return type;
	}

	// add weight
	public void addWeight(double amount) throws IllegalArgumentException {
		if(amount < 0) {
			throw new IllegalArgumentException("Added resource amount must be greater than 0.\n");
		}
		else {
		this.weight = weight + amount;
		}
	}

	
	// subtract weight
	public void subWeight(double amount) {
		if(weight < amount) {
			throw new IllegalArgumentException("Subtract resource amount must be less than current resource weight.\n");
		}
		else {
		this.weight = weight - amount;
		}
	}
}

