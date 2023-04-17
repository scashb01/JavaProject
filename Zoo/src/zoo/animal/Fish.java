package zoo.animal;
 
public abstract class Fish extends Animal{

	protected Water water;

	private final String type = "Fish";

	public Fish() {
		super();
		this.water = Water.UNKNOWN;
	}

	public <T> Fish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	public <T> Fish(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight);
		this.setWater(water);
	}

	public Water getWater() {
		return this.water;
	}

	public <T> void setWater(T water) throws Exception {

		if(water instanceof String) {

			String s = (String) water;

			s = s.toLowerCase();
	
			switch(s) {
			case "s":
			case "salt":
			case "saltwater":
				this.water = Water.SALT;
			
			}
		}
	}


	@Override
	public String toString() {
		return this.id + " " + this.type + " " + this.getBirthdateStr() + " " + this.getWeight();
	}
}
