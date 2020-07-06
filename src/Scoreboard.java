// This Object will handle all score board operations.
public class Scoreboard {
	// Initialize vars.
	int SavedScoreP1 = 0;
	int SavedScoreP2 = 0;
	int round = 0;
	
	// This function calculates the score using an accumulator system.
	public void update(int ScoreP1, int ScoreP2) {
		SavedScoreP1+=ScoreP1;
		SavedScoreP2+=ScoreP2; 
	}
	// Prints the current score and round.
	public void display(int round) {
		System.out.println("ROUND:"+round
				+ "\nCurrent scores:P1    P2\n"
				+ "               "+SavedScoreP1+"     "+SavedScoreP2);
	}
}
