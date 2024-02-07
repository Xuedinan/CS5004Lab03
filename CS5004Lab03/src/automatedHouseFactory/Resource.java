package automatedHouseFactory;

public class Resource {
	
	private double weight;
	private ResourceType type;
	
	
	// constructor
	public Resource(double weight, ResourceType type) {

		this.weight = weight;
		this.type = type;
	}

	
	// setters and getters
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}
	
	
	// add weight TODO add check condition, exception
	public void addWeight(double amount) {
		this.weight = weight + amount;
	}
	
	// subtract weight TODO add check condition, exception
	public void subWeight(double amount) {
		this.weight = weight - amount;
	}
}	
	
