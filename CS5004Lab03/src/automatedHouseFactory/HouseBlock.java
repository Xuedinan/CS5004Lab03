package automatedHouseFactory;

public class HouseBlock extends Block {
	
	public HouseBlock(WoodBlock wood, StoneBlock stone) {
		
		HouseBlock.type = ResourceType.HOUSE;
		HouseBlock.weight = wood.getWeight() + stone.getWeight();
		
	}
	
	
	// TODO inventory check?
	
	
	public HouseBlock() {
	}


	@Override
	public Resource breakBlock() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
