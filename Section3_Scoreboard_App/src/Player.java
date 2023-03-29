
public class Player {
	private String name;
	private int jersey;
	private int foul;
	private int fieldGoals_1pt;
	private int fieldGoals_2pt;
	private int fieldGoals_3pt;
	
	public Player() {
		this.name = "unknown";
		this.jersey = 0;
		this.foul = 0;
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_3pt = 0;
	}
	public Player(int jersey) {
		this.name = "unknown";
		this.jersey = jersey;
		this.foul = 0;
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_3pt = 0;
	}
	
	public Player(String name, int jersey) {
		this.name = name;
		this.jersey = jersey;
		this.foul = 0;
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_3pt = 0;
	}
//Gets the player's name.
	public String getName() {
		return name;
	}
	
//Sets the player's name.
	public void setName(String name) {
		this.name = name;
	}
//Gets the players jersey number.
	public int getJersey() {
		return jersey;
	}
//Sets the player's jersey number if it's a positive number between 1 and 99.
	public void setJersey(int jersey) throws Exception {
		if (jersey > 0 && jersey < 99)
			this.jersey = jersey;
		else
			throw new Exception("Jersey number must be between 0-99.");
	}
	
//Gets the player's number of fouls.
	public int getFoul() {
		return foul;
	}
	
//Gets the player's number of 1pt field goals made.
	public int getFieldGoals_1pt() {
		return fieldGoals_1pt;
	}

//Gets the player's number of 2pt field goals made.
	public int getFieldGoals_2pt() {
		return fieldGoals_2pt;
	}
	
//Gets the player's number of 3pt field goals made.
	public int getFieldGoals_3pt() {
		return fieldGoals_3pt;
	}
	
//Increments the player's fouls by 1.
	public void foul() {
		this.foul++;
	}

//Increments the appropriate field goal type.
	public void shot(int shotType) {
		switch(shotType) {
		case 1:
			this.fieldGoals_1pt++;
		case 2:
			this.fieldGoals_2pt++;
		case 3: 
			this.fieldGoals_3pt++;
		default:
		System.out.println("invaild shot type: " + shotType );
		}
	}

//Get the player's total points by calculating it by the field goal types.
	public int getPoints() {
		int totalPoints = 0;
		totalPoints += this.fieldGoals_1pt;
		totalPoints += this.fieldGoals_2pt * 2;
		totalPoints += this.fieldGoals_3pt * 3;
		return totalPoints;
		
	}
	
//Displays the player's jersey number, name, # of fouls, and # of points.
	public void displayStats() {
		System.out.printf("#" + this.jersey + " " + this.name + " fouls = " + this.foul 
				+ " Points = " + this.getPoints());
		
	}
	
//Verify's two players are the same by only using their jersey numbers.
	public boolean equals (Object object) {
	if (!(object instanceof Player))
		return false;
	
	Player other = (Player) object;
	if (this.jersey == other.getJersey())
		return true;
	else
		return false;
	}
	
}
