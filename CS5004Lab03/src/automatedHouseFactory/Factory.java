package automatedHouseFactory;

/*
Name: Xuedinan Gao
Course: CS 5004
Semester: Spring 2024
*/

public interface Factory {

	public <T> void takeResource(Object resource);
	
	public Block produce();
	
	public void displayInventory();
	
}