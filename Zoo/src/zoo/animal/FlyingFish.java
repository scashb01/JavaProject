package zoo.animal;

public class FlyingFish extends Fish  implements Flying, Swim{

	private final String type = "FlyingFish";

	public FlyingFish() {
		super();
	}

	public <T> FlyingFish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	public <T> FlyingFish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight, water);
	}

	@Override
	public String toString() {
		return this.id + " " + this.type + " " + this.getBirthdateStr() + " " + this.getWeight();
	}

	@Override
	public void soar() {
		
	}

	@Override
	public void glide() {
		
	}
 
	@Override
	public void eat() {
		
	}

	@Override
	public void dive() {
				
	}

	@Override
	public void rise() {
		
		
	}
}
