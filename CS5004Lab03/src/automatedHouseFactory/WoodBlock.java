package automatedHouseFactory;

public class WoodBlock extends Block{
	
	// create wood block with constants
	public WoodBlock() {
		super(ResourceType.WOOD, Const.aWoodBlockWeight);
	}
	
	@Override // return half weight of wood
	public Resource breakBlock() {
		
		return new Resource(Const.aWoodBlockWeight / 2, ResourceType.WOOD);
	}

}
 