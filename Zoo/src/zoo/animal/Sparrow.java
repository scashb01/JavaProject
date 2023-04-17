package zoo.animal;

public class Sparrow extends Bird {

	private final String type = "Sparrow";

	public Sparrow() {
		super();
	}

	public <T> Sparrow(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	public <T> Sparrow(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}

	public String toString() {
		return this.id + " " + this.type + " " + this.getBirthdateStr() + " " + this.getWeight() + " " + this.getWingspan();
	}
	@Override
	public void eat() {
		 
	}
}