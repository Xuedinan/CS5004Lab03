package automatedHouseFactory;

public class WoodBlock extends Block{
	
	
	public WoodBlock() {
		this.type = ResourceType.WOOD;
		this.weight = Const.aWoodBlockWeight;
	}
	
	// TODO more check
	
	@Override
	public Resource breakBlock() {
		
		return new Resource(super.weight / 2, this.type);
	}

}
