package CarDemo;

public class Car {
	
    private double weight; // all car has weight
    private int wheelsNumber = 4; // all car has 4 wheels, default is 4
    private String engineType; // all car has engine type
    private String color; // all car has own color

    // we set different data type for different field

	public Car(double weight, int wheelsNumber, String engineType, String color) {

		this.weight = weight;
		this.wheelsNumber = wheelsNumber;
		this.engineType = engineType;
		this.color = color;
		
    	// this.weight = weight, means for anyone who wants to use our blueprint (constructor) 
    	// to build their car, they will provide their car's weight and upload to the blueprint
    	// it's the same logic to other fields
	}

	public double getWeight() {
		return weight;
	}

	public int getWheelsNumber() {
		return wheelsNumber;
	}

	public String getEngineType() {
		return engineType;
	}

	public String getColor() {
		return color;
	}

	// all above getter methods will help the factories who using our blueprint(Car Class) to 
	// get the details information for their own car based on our design requirement
	
	
	
	
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
//	public void setWheelsNumber(int wheelsNumber) {
//		this.wheelsNumber = wheelsNumber;
//	}
	
	// all above setters provide access for the factories to update the data for their own car
	// we don't want to provide setWheelsNumber method because in our design all the car
	// must has 4 wheels, so we don't want it changed.
	
}
