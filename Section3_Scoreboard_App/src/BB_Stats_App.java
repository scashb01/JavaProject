public class BB_Stats_App {
	
    /**
     * The first Team playing
     */
    private Team homeTeam;
    
    /**
     * The second Team playing. 
     */
    private Team awayTeam;
    
    /**
     * Use to display a double dash line
     */
    private final static String DOUBLE_LINE = "=========================================";
    
    /**
     * Used to display a single dash line 
     */
    private final static String SINGLE_LINE = "-----------------------------------------"; 
    
    /**
     * Default constructor that instantiate  both teams
     */
    private BB_Stats_App() {
    	
    	homeTeam = new Team();
        awayTeam = new Team();
        
    } // end of default constructor
    
    /**
     *  Displays the BB Stats App header
     */
    private void displayAppHeading() {
    	
		System.out.println(DOUBLE_LINE);
		System.out.println("Welcome to the BB Scoreboard App");
		System.out.println(DOUBLE_LINE);
		System.out.println();
		
    } // end of displayAppHeading
    
    /**
     * Sets the teams names and calls setupPlayers to setup each team's players
     */
    private void setupTeams() {
    	
    	String userInput = null;
  		
		userInput = Input.getLine("Enter the HOME Team name: ");
		this.homeTeam.setName(userInput);
		this.setupPlayers(homeTeam);

		System.out.println();
		System.out.println(SINGLE_LINE);
		System.out.println();

		userInput = Input.getLine("Enter the AWAY TEAM name: ");
		this.awayTeam.setName(userInput);
		this.setupPlayers(this.awayTeam);
    	
    } // end of setupTeams
    
    /**
     * Sets up the team's players
     * 
     * @param team The team to setup players for
     */
    private void setupPlayers(Team team) {
    	String teamName = team.getName();
    	String name = null;
    	int jersey = 0;

    	while (true) {
			System.out.println();
			name = Input.getLine("Enter " + teamName + " player's name or 'q' to quit: ");
			
			if (name.equals("q"))
				return;
			
			try { 
				jersey = Input.getIntRange("Enter " + name + " jersey number: ", 0, 99);		
				team.addPlayer(name, jersey);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Unable to add player!");
			}
			
    	}
		    	
    } // end of setupPlayers
    
    /**
     * Keeps the game running via menu options
     * @throws Exception updateTeamStats could throw an error if an invalid option is selected
     */
    private void playGame() throws Exception {
    	
    	boolean playGame = true;
    	int userInput = 0;
    	
    	System.out.println();
    	System.out.println(DOUBLE_LINE);    	
    	System.out.println("Game Started!");
    	System.out.println(DOUBLE_LINE);
    	System.out.println();
    	
    	
    	while (playGame) {
    		
    		System.out.println(SINGLE_LINE);
    		System.out.println("Main Menu");
    		System.out.println(SINGLE_LINE);
    		
    		System.out.println("0 = End Game");
    		System.out.println("1 = Enter " + homeTeam.getName() + " Team's Stats");
    		System.out.println("2 = Enter " + awayTeam.getName() + " Team's Stats");
    		System.out.println("3 = Display Game Stats");
    		
    		System.out.println(SINGLE_LINE);
    		userInput = Input.getIntRange("Menu Choice: ", 0, 3);
    		System.out.println(SINGLE_LINE);
    		
    		System.out.println();
    		
    		switch (userInput) {
    		case 0:
    			playGame = false;
    			this.updateScoreboard();
        		System.out.println();
        		break;
        		
    		case 1:
    		case 2:
    			
    			if (userInput == 1)
    				this.updateTeamStats(homeTeam);
    			else
    				this.updateTeamStats(awayTeam);
    			
    			System.out.println();
        		this.updateScoreboard();
        		System.out.println();
        		break;
        		
    		case 3:
    			this.displayGameStatus();
    			break;
    			
    		default:
    			System.out.println("Invalid menu choice = " + userInput);
    			
    		} // end of switch
    	}

    } // end of playGame
    
    /**
     * Update the select team's stats
     * @param team The team to enter stats for
     * @throws Exception getPlayer could throw an invalid jersey error
     */
    private void updateTeamStats(Team team) throws Exception {

    	int jersey = 0;
    	Player player;
    	
		while (true) {
			jersey = Input.getIntRange("Enter " + team.getName() + "'s Jersey # ", 1, 99);
			
			player = team.getPlayer(jersey);
			
			if (player == null) {
				System.out.println("Invalid #, please try again!");
				continue;
			}
			
			this.updatePlayerStats(player);
			
			break;
		}
			
		System.out.println();
		System.out.println(SINGLE_LINE);
			
    } // end of updateTeam
    
    /**
     * Update the player's stats
     * 
     * @param player The player to enter stats for
     */
    private void updatePlayerStats(Player player) {
    	int type = 0;
    	int made = 0;
    	
		System.out.println();
		
		System.out.println(SINGLE_LINE);
		System.out.println("Enter #" + player.getJersey() + " " +player.getName() + " Stats");
		System.out.println(SINGLE_LINE);
		
		System.out.println("0 = foul");
		System.out.println("1 = free throw");
		System.out.println("2 = 2pt field goal");
		System.out.println("3 = 3pt field goal");
		
		System.out.println(SINGLE_LINE);
		type = Input.getIntRange("Enter Stat Type: ", 0, 3);
		System.out.println(SINGLE_LINE);
		
		if (type == 0)
			player.foul();
		else
			try {
				player.shot(type);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Unable to update player's stats!");
			}

		player.displayStats();

    }
    
    /**
     * Display the updated Scoreboard for both teams
     */
    private void updateScoreboard() {
    	
    	this.homeTeam.displayTeamStats();
    	this.awayTeam.displayTeamStats();
    	
    }
    
    /**
     * Display all team player's detail stats
     */
    private void displayGameStatus() {

    	this.homeTeam.displayDetailStats();
    	this.awayTeam.displayDetailStats();

    } // end of playGame
    
	/**
	 * Main method that creates the BB_Stats_App object and then
	 * setups up the teams and play the game via menu options.
	 * 
	 * @param args No command line input args are used for this application
	 * @throws Exception numerous methods could throw errors back to main
	 */
	public static void main(String[] args) throws Exception {

		BB_Stats_App app = new BB_Stats_App();
		
		app.displayAppHeading();
		
		try {
			app.setupTeams();
			app.playGame();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Sorry but this program ended with an error. Please contact Princess Debbie!");
		}
		
		Input.sc.close();
		
	} // end of main
	
} // end of BB_Stats_App class