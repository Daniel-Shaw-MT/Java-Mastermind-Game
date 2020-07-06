import java.util.concurrent.TimeUnit;

// This class will handle all possible game states.
public class GameStateController {
	Scoreboard board = new Scoreboard();
	// This function will "clear" the console.
	public void clear() {
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	// This function will win the game and update the score board.
	public void winstate() throws InterruptedException {
		System.out.println("Game over! Player 2 Cracked the code!");
		
		TimeUnit.SECONDS.sleep(2);
	}
	
	// This function will end the game and update the score board.
	public void gameover() throws InterruptedException {
		System.out.println("Game over! Player 2 Couldn't crack the code!");
		
		TimeUnit.SECONDS.sleep(2);
	}
}
