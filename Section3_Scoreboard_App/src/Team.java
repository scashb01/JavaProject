import java.util.List;
import java.util.ArrayList;

public class Team {

	private String name;
	private List<Player> players;
	
	public Team() {
		this.name = "unknown";
		this.players = new ArrayList<Player>();
		
	}
	
	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<Player>();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


// Adds a player to the Team and makes sure that jersey isn't already being used.
	public void addPlayer(String name, int jersey) throws Exception {
		
		Player dupPlayer = this.getPlayer (jersey);
		if (dupPlayer == null) {
			this.players.add(new Player(name, jersey));
		}else {
			throw new Exception("Jersey #" + jersey + " already assigned to " + dupPlayer.getName() + "!");
		}
	}
	
	
//Gets a Player by their jersey number
	public Player getPlayer(int jersey) {
		
		int index = this.players.indexOf(new Player(jersey));
		if (index == -1) {
			return null;
		}
		else {
			return this.players.get(index);
		}
	
		
	} 
	
//this gets the number of points for the entire Team
		public int getTeamPoints	() {
			int teamPoints = 0;
			for(int i = 0; i < this.players.size(); i++){
				teamPoints += this.players.get(i).getPoints();
		
			}
			
			return teamPoints;
		
		}
		
//This gets the total number of team fouls 
		public int getTeamFouls() {
			int teamFouls = 0;
			
			for(int i = 0; i < this.players.size(); i++){
				teamFouls += this.players.get(i).getFoul();
			}
			return teamFouls;
		}
		
//Displays the team's stats summary.
		public void displayTeamStats() {
			System.out.printf("Team " + this.name + " fouls = " + this.getTeamFouls()
					+ " Points = " + this.getTeamPoints());
		}
		
	
//Displays each player's stats for the team.
			public void displayDetailStats() {
				System.out.println("Jersey Name            Fouls 1pt 2pt 3pt Total");
				System.out.println("===========            ===== === === === =====");
				
				for(int i = 0; i < this.players.size(); i++) {			
					System.out.printf("%6d %-15s %5d %3d %3d %3d %5d\n",
		
					players.get(i).getJersey(),
					players.get(i).getName(),
					players.get(i).getFoul(),
					players.get(i).getFieldGoals_1pt(),
					players.get(i).getFieldGoals_2pt(),
					players.get(i).getFieldGoals_3pt(),
					players.get(i).getPoints());
				}
			System.out.println();
			}
	}
			
	

