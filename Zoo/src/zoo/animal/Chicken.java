package zoo.animal;
 
public class Chicken extends Bird {

	private final String type = "Chicken";

	public Chicken() {
		super();
		this.wingspan = 0;
	}

	public <T> Chicken(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	public <T> Chicken(T birthdate, float weight, T wingspan) throws Exception {
		super(birthdate, weight);
	}

	@Override
	public String toString() {
		return this.id + " " + this.type + " " + this.getBirthdateStr() + " " + this.getWeight() + " " + this.getWingspan();
	}
	
	@Override
	public void eat() {
		System.out.println("This " + this.type + " is eating.");
	}
}
