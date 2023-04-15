package zoo.animal;

public class Guppy extends Fish {

	private final String type = "Guppy";

	public Guppy() {
		super();
	}

	public <T> Guppy(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	public <T> Guppy(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight, water);
	}

	@Override
	public String toString() {
		return this.id + " " + this.type + " " + this.getBirthdateStr() + " " + this.getWeight();
	}

	@Override
	public void eat() {
		
	}
}