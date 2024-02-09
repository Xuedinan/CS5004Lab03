package automatedHouseFactory;

public class StoneBlock extends Block{

	public StoneBlock() {
		super(ResourceType.STONE, Const.aStoneBlockWeight);
	}

	@Override
	public Resource breakBlock() {
		
		return new Resource(Const.aStoneBlockWeight, ResourceType.STONE);
				
	}

}
