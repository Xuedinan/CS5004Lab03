package automatedHouseFactory;

public interface Factory {

	public <T> void takeResource(Object resource);
	
	public Block produce();
	
	public void displayInventory();
	
}