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
/**
 * @author scoutashburn
 *
 */
public abstract class Animal {

	/**
	 * 
	 */
	private static int counter = 0;

	/**
	 * 
	 */
	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);

	/**
	 * 
	 */
	protected final int id;

	/**
	 * 
	 */
	protected Gender gender;

	/**
	 * 
	 */
	protected final String type = "Animal";

	/**
	 * 
	 */
	private LocalDate birthdate;

	/**
	 * 
	 */
	private float weight;

	/**
	 * 
	 */
	public  Animal() {
		this.id = ++Animal.counter;
		this.birthdate = null;
		this.weight = 0;
		this.gender = Gender.UNKNOWN;
	}

	/**
	 * @param <T>
	 * @param birthdate
	 * @param weight
	 * @throws Exception
	 */
	public <T> Animal (T birthdate, float weight)throws Exception {
		this();
		this.setBirthdate(birthdate);
		this.setWeight(weight);
	}


	/**
	 * @param <T>
	 * @param gender
	 * @throws Exception
	 */
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
	/**
	 * @return
	 */
	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	/**
	 * @return
	 */
	public String getBirthdateStr() {
		if (this.birthdate == null)
			return "UNKNOWN";
		else 
			return this.FORMAT.format(this.birthdate);
	}


	/**
	 * @param <T>
	 * @param birthdate
	 * @throws Exception
	 */
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
	/**
	 * @return
	 */
	public float getWeight() {
		return this.weight;
	}

	/**
	 * @param weight
	 * @throws Exception
	 */
	public void setWeight(float weight) throws Exception {
		if ( weight > 0)
			this.weight = weight;
		else
			throw new Exception("Invalid Weight: "  + weight);

	}

	/**
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	
	/**
	 * @return
	 */
	public Gender getGender() {;
	return this.gender;
	}



	/**
	 * @return
	 */
	public String getType() {
		return this.getType();
	}

	/**
	 *
	 */
	@Override public String toString() {
		return this.id + " " + this.type;
	}


	/**
	 * 
	 */
	abstract public void eat();
}



