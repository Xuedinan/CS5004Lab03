package automatedHouseFactory;

/*
Name: Xuedinan Gao
Course: CS 5004
Semester: Spring 2024
*/

public class ConcreteBlock extends Block{
	
	// create stone block with constants
	public ConcreteBlock() {
		super(ResourceType.CONCRETE, Const.aConcreteBlockWeight);
	}

	@Override // return all weight of stone
	public Resource breakBlock() {
		
		// Concrete won't return when block break
		return new Resource(0, ResourceType.CONCRETE);
				
	}

}
