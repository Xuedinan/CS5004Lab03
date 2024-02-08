package automatedHouseFactory;

public class HouseFactory implements Factory {
	
	private double stoneBlockBin;
	private double woodBlockBin;

	@Override // TODO check instanceof check
	public <T> void takeResource(Object resource) {
		
		Block blcok = (Block)resource;
		
		if(Block.getType() == ResourceType.STONE) {
			Block block = (StoneBlock) blcok;
			stoneBlockBin += block.getWeight();
		}
		else if(Block.getType() == ResourceType.WOOD) {
			Block block = (WoodBlock) blcok;
			woodBlockBin += block.getWeight();
		}
	}
				

	@Override
	public Block produce() {
		// TODO Auto-generated method stub
		return new HouseBlock();
	}

	@Override
	public Object displayInventory() {

		return "Stone Blocks: " + stoneBlockBin + "\n" + "Wood Blocks: " + woodBlockBin;
	}
}