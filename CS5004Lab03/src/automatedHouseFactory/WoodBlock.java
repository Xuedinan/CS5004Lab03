package automatedHouseFactory;

public class WoodBlock extends Block{
	
	
	public WoodBlock() {
		super(ResourceType.WOOD, Const.aWoodBlockWeight);
	}
	
	// TODO more check
	
	@Override
	public Resource breakBlock() {
		
		return new Resource(Const.aWoodBlockWeight / 2, ResourceType.WOOD);
	}

}
 