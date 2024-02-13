package automatedHouseFactory;

public class ConcreteBlockFactory implements Factory {	
	
	// raw concrete material inventory
	public double cResourceBin;
	
	// Constructor
	public ConcreteBlockFactory() {};
	
	
	@Override
	public void takeResource(Object resource) throws IllegalArgumentException{

		// check if resource is Resource type
		if(resource instanceof Resource) {
			
			// cast resource to Resource type
			Resource castResource = (Resource) resource;
			
			// check if resource type is concrete, cast Object to Resource
			if(castResource.getType() == ResourceType.CONCRETE) {
				
					// take concrete weight from resource and add to cResourceBin
					cResourceBin += castResource.getWeight();
				}
			else {
					throw new IllegalArgumentException("The input resource for ConcreteBlockFactory is not concrete.\n");
				}
			 }
		else {
			throw new IllegalArgumentException("Resource for ConcreteBlockFactory is invalid.\n");
		}
	}

	
	@Override
	public Block produce() {
		
		// check if concrete inventory is sufficient to build woodBlock
		if(cResourceBin - Const.aConcreteBlockWeight > 0.00000001) {
			
			// if concrete is sufficient then subtract the cost of concreteBlock from inventory
			cResourceBin -= Const.aConcreteBlockWeight;
			
			// concreteBlock built
			return new ConcreteBlock();
		}
		else {
			return null;
		}
	}

	@Override
	public void displayInventory() {
		System.out.printf("%.1f\n", cResourceBin);
	}

}
