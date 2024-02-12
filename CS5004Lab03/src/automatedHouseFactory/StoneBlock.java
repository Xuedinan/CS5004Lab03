package automatedHouseFactory;

public class StoneBlock extends Block{
	
	// create stone block with constants
	public StoneBlock() {
		super(ResourceType.STONE, Const.aStoneBlockWeight);
	}

	@Override // return all weight of stone
	public Resource breakBlock() {
		
		return new Resource(Const.aStoneBlockWeight, ResourceType.STONE);
				
	}

}
