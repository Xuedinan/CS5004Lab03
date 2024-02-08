package automatedHouseFactory;

public class StoneBlock extends Block{

	public StoneBlock() {
		super(ResourceType.STONE, Const.aStoneBlockWeight);
	}

	// TODO condition check
	@Override
	public Resource breakBlock() {
		
		return new Resource(super.weight, this.type);
				
	}

}
