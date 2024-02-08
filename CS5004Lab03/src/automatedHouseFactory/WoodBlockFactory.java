package automatedHouseFactory;

public class WoodBlockFactory implements Factory {	
	
	private Resource resourceBin;

	
	public WoodBlockFactory() {};
	
	
	// TODO check if ResourceType is correct
	@Override
	public <T> void takeResource(Object resource) {
		
	 resourceBin.addWeight(((Resource) resource).getWeight());
		
	}
	
	@Override // TODO check if resource is enough
	public Block produce() {
		return new StoneBlock();
		
	}
	
	@Override
	public Object displayInventory() {
		return resourceBin.getWeight();
		
	}

}
