package zoo.animal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 
 * @author Scout Ashburn
 *
 *default class for setting up an animal
 */
public abstract class Animal {

	private static int counter = 0;

	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	protected final int id;

	protected Gender gender;

	protected final String type = "Animal";

	private LocalDate birthdate;

	private float weight;

	public  Animal() {
		this.id = ++Animal.counter;
		this.birthdate = null;
		this.weight = 0;
		this.gender = Gender.UNKNOWN;
	}

	public <T> Animal (T birthdate, float weight)throws Exception {
		this();
		this.setBirthdate(birthdate);
		this.setWeight(weight);
	}


	public <T> void setGender (T gender) throws Exception {
		if(gender instanceof String) {
			String s = (String) gender;

			s=s.toLowerCase();

			switch (s) {
			case "m" :
			case "male":
				this.gender = Gender.Male; 
				break;
			case "f":
			case "female" :
				this.gender = Gender.Female;
				break;
			default:
				throw new Exception("Invalid Gender: " + s);
			}

		}else if (gender instanceof Gender) {
			this.gender = (Gender) gender;

		} else {
			throw new Exception("Invalid Gender:" + gender);
		}
	}


/**
 * Gets the animals birthdate 
 * @return
 */
	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	public String getBirthdateStr() {
		if (this.birthdate == null)
			return "UNKNOWN";
		else 
			return this.FORMAT.format(this.birthdate);
	}


	public <T> void setBirthdate(T birthdate)throws Exception {



		if (birthdate instanceof String) {

			this.birthdate = LocalDate.parse (( String) birthdate, Animal.FORMAT);
		}else if (birthdate instanceof LocalDate) {

			LocalDate date = (LocalDate) birthdate;
			this.birthdate = date;
		}else {
			throw new Exception ("invalid date MM-dd-yyyy: " +birthdate);
		}
	}
	/**
	 * gets animals weight 
	 * @return
	 */
	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) throws Exception {
		if ( weight > 0)
			this.weight = weight;
		else
			throw new Exception("Invalid Weight: "  + weight);

	}

	public int getId() {
		return this.id;
	}

	
	public Gender getGender() {;
	return this.gender;
	}



	public String getType() {
		return this.getType();
	}

	@Override public String toString() {
		return this.id + " " + this.type;
	}


	abstract public void eat();
}



